/*-
 * #%L
 * This file is part of QuPath.
 * %%
 * Copyright (C) 2018 - 2020 QuPath developers, The University of Edinburgh
 * %%
 * QuPath is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * QuPath is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License 
 * along with QuPath.  If not, see <https://www.gnu.org/licenses/>.
 * #L%
 */

package qupath.opencv.ops;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.bytedeco.javacpp.PointerScope;
import org.bytedeco.opencv.global.opencv_core;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.junit.jupiter.api.Test;

import qupath.lib.io.GsonTools;
import qupath.opencv.tools.OpenCVTools;

@SuppressWarnings("javadoc")
public class ImageOpsTest {
	
	/**
	 * Test the application and serialization of ImageOps.
	 */
	@Test
	public void testSerialization() {
		
		int size = 256;
		int nChannels = 3;
		int seed = 100;
		try (@SuppressWarnings("unchecked")
		var scope = new PointerScope()) {
			// Create a Mat with zeros, then add noise & check it made a difference
			var matZeros = createZerosMat(size, nChannels);
			var matNoise = matZeros.clone();
			assertTrue(matsEqual(matZeros, matNoise, 0));
			
			addNoise(matNoise, seed);
			assertFalse(matsEqual(matZeros, matNoise, 0));
			
			// Create an op & apply it to the noise Mat
			// Ensure it has an impact
			var op = createOp(1, 2);
			var matNoise2 = matNoise.clone();
			matNoise2 = op.apply(matNoise2);
			
			assertFalse(matsEqual(matNoise, matNoise2, 0));
			
			// Reconstruct the op from its JSON-serialized form and check it has the same output
			var json = GsonTools.getInstance(true).toJson(op, ImageOp.class);
			var op2 = GsonTools.getInstance().fromJson(json, ImageOp.class);
			
			var matNoise3 = matNoise.clone();
			matNoise3 = op2.apply(matNoise3);
			
			assertTrue(matsEqual(matNoise2, matNoise3, 1e-6));
			
			// Reconstruct the op from its JSON-serialized form with legacy op names
			// (i.e. missing some categories) and check the results match
			var jsonLegacy = json.replaceAll("op.filters.", "op.")
					.replaceAll("op.ml.", "op.")
					.replaceAll("op.normalize.", "op.")
					.replaceAll("op.threshold.", "op.");
			assertNotEquals(json, jsonLegacy);
			var opLegacy = GsonTools.getInstance().fromJson(jsonLegacy, ImageOp.class);
			
			var matNoiseLegacy = matNoise.clone();
			matNoiseLegacy = opLegacy.apply(matNoiseLegacy);
			
			assertTrue(matsEqual(matNoise2, matNoiseLegacy, 1e-6));
			
			// Ensure that writing the legacy op gives the same JSON
			var jsonLegacyRecovered = GsonTools.getInstance(true).toJson(opLegacy, ImageOp.class);
			assertEquals(json, jsonLegacyRecovered);
		}

				
	}
	
	/**
	 * Compare if two Mats are equal in terms of dimensions and values.
	 * @param m1
	 * @param m2
	 * @param tol
	 * @return
	 */
	private static boolean matsEqual(Mat m1, Mat m2, double tol) {
		if (m1.rows() != m2.rows() || m1.cols() != m2.cols() || m1.channels() != m2.channels())
			return false;
		Mat matDiff = new Mat();
		opencv_core.absdiff(m1, m2, matDiff);
		for (var channel : OpenCVTools.splitChannels(matDiff)) {
			if (opencv_core.countNonZero(opencv_core.greaterThan(channel, tol).asMat()) != 0)
				return false;
		}
		return true;
	}
	
	private Mat createZerosMat(int size, int nChannels) {
		return new Mat(size, size, opencv_core.CV_32FC(nChannels), Scalar.ONE);
	}
	
	private void addNoise(Mat mat, int seed) {
		opencv_core.setRNGSeed(seed);
		opencv_core.randn(mat, 
				new Mat(1, 1, opencv_core.CV_32FC1, Scalar.ZERO),
				new Mat(1, 1, opencv_core.CV_32FC1, Scalar.ONE));
	}
	
	private ImageOp createOp(int... channels) {
		return ImageOps.Core.sequential(
				ImageOps.Channels.extract(channels),
				ImageOps.Filters.gaussianBlur(4.0),
				ImageOps.Threshold.thresholdMeanStd(0.5),
				ImageOps.Filters.maximum(4),
				ImageOps.Filters.closing(2)
				);
	}

}