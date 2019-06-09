package math;

public class Matrix4 {
	
	public float[][] matrix;
	
	public static Matrix4 add(Matrix4 mat1, Matrix4 mat2) {
		return add(mat1, mat2);
	}
	
	public static Matrix4 subtract(Matrix4 mat1, Matrix4 mat2) {
		return subtract(mat1, mat2);
	}
	
	public Matrix4() {
		matrix = new float[4][4];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = 0;
			}
		}
	}

	public static Matrix4 multiply(Matrix4 mat1, Matrix4 mat2) {
		Matrix4 m = new Matrix4();
		m.matrix[0][0] = (mat1.matrix[0][0] * mat2.matrix[0][0]) + (mat1.matrix[1][0] * mat2.matrix[0][1]) + (mat1.matrix[2][0] * mat2.matrix[0][2]) + (mat1.matrix[3][0] * mat2.matrix[0][3]);
		m.matrix[0][1] = (mat1.matrix[0][1] * mat2.matrix[0][0]) + (mat1.matrix[1][1] * mat2.matrix[0][1]) + (mat1.matrix[2][1] * mat2.matrix[0][2]) + (mat1.matrix[3][1] * mat2.matrix[0][3]);
		m.matrix[0][2] = (mat1.matrix[0][2] * mat2.matrix[0][0]) + (mat1.matrix[1][2] * mat2.matrix[0][1]) + (mat1.matrix[2][2] * mat2.matrix[0][2]) + (mat1.matrix[3][2] * mat2.matrix[0][3]);
		m.matrix[0][3] = (mat1.matrix[0][3] * mat2.matrix[0][0]) + (mat1.matrix[1][3] * mat2.matrix[0][1]) + (mat1.matrix[2][3] * mat2.matrix[0][2]) + (mat1.matrix[3][3] * mat2.matrix[0][3]);
		
		m.matrix[1][0] = (mat1.matrix[0][0] * mat2.matrix[1][0]) + (mat1.matrix[1][0] * mat2.matrix[1][1]) + (mat1.matrix[2][0] * mat2.matrix[1][2]) + (mat1.matrix[3][0] * mat2.matrix[1][3]);
		m.matrix[1][1] = (mat1.matrix[0][1] * mat2.matrix[1][0]) + (mat1.matrix[1][1] * mat2.matrix[1][1]) + (mat1.matrix[2][1] * mat2.matrix[1][2]) + (mat1.matrix[3][1] * mat2.matrix[1][3]);
		m.matrix[1][2] = (mat1.matrix[0][2] * mat2.matrix[1][0]) + (mat1.matrix[1][2] * mat2.matrix[1][1]) + (mat1.matrix[2][2] * mat2.matrix[1][2]) + (mat1.matrix[3][2] * mat2.matrix[1][3]);
		m.matrix[1][3] = (mat1.matrix[0][3] * mat2.matrix[1][0]) + (mat1.matrix[1][3] * mat2.matrix[1][1]) + (mat1.matrix[2][3] * mat2.matrix[1][2]) + (mat1.matrix[3][3] * mat2.matrix[1][3]);
		
		m.matrix[2][0] = (mat1.matrix[0][0] * mat2.matrix[2][0]) + (mat1.matrix[1][0] * mat2.matrix[2][1]) + (mat1.matrix[2][0] * mat2.matrix[2][2]) + (mat1.matrix[3][0] * mat2.matrix[2][3]);
		m.matrix[2][1] = (mat1.matrix[0][1] * mat2.matrix[2][0]) + (mat1.matrix[1][1] * mat2.matrix[2][1]) + (mat1.matrix[2][1] * mat2.matrix[2][2]) + (mat1.matrix[3][1] * mat2.matrix[2][3]);
		m.matrix[2][2] = (mat1.matrix[0][2] * mat2.matrix[2][0]) + (mat1.matrix[1][2] * mat2.matrix[2][1]) + (mat1.matrix[2][2] * mat2.matrix[2][2]) + (mat1.matrix[3][2] * mat2.matrix[2][3]);
		m.matrix[2][3] = (mat1.matrix[0][3] * mat2.matrix[2][0]) + (mat1.matrix[1][3] * mat2.matrix[2][1]) + (mat1.matrix[2][3] * mat2.matrix[2][2]) + (mat1.matrix[3][3] * mat2.matrix[2][3]);
	
		m.matrix[3][0] = (mat1.matrix[0][0] * mat2.matrix[3][0]) + (mat1.matrix[1][0] * mat2.matrix[3][1]) + (mat1.matrix[2][0] * mat2.matrix[3][2]) + (mat1.matrix[3][0] * mat2.matrix[3][3]);
		m.matrix[3][1] = (mat1.matrix[0][1] * mat2.matrix[3][0]) + (mat1.matrix[1][1] * mat2.matrix[3][1]) + (mat1.matrix[2][1] * mat2.matrix[3][2]) + (mat1.matrix[3][1] * mat2.matrix[3][3]);
		m.matrix[3][2] = (mat1.matrix[0][2] * mat2.matrix[3][0]) + (mat1.matrix[1][2] * mat2.matrix[3][1]) + (mat1.matrix[2][2] * mat2.matrix[3][2]) + (mat1.matrix[3][2] * mat2.matrix[3][3]);
		m.matrix[3][3] = (mat1.matrix[0][3] * mat2.matrix[3][0]) + (mat1.matrix[1][3] * mat2.matrix[3][1]) + (mat1.matrix[2][3] * mat2.matrix[3][2]) + (mat1.matrix[3][3] * mat2.matrix[3][3]);
		
		return m;
	}
	
	public static Matrix4 divide(Matrix4 mat1, Matrix4 mat2) {
		Matrix4 m = new Matrix4();
		m.matrix[0][0] = (mat1.matrix[0][0] / mat2.matrix[0][0]) + (mat1.matrix[1][0] / mat2.matrix[0][1]) + (mat1.matrix[2][0] / mat2.matrix[0][2]) + (mat1.matrix[3][0] / mat2.matrix[0][3]);
		m.matrix[0][1] = (mat1.matrix[0][1] / mat2.matrix[0][0]) + (mat1.matrix[1][1] / mat2.matrix[0][1]) + (mat1.matrix[2][1] / mat2.matrix[0][2]) + (mat1.matrix[3][1] / mat2.matrix[0][3]);
		m.matrix[0][2] = (mat1.matrix[0][2] / mat2.matrix[0][0]) + (mat1.matrix[1][2] / mat2.matrix[0][1]) + (mat1.matrix[2][2] / mat2.matrix[0][2]) + (mat1.matrix[3][2] / mat2.matrix[0][3]);
		m.matrix[0][3] = (mat1.matrix[0][3] / mat2.matrix[0][0]) + (mat1.matrix[1][3] / mat2.matrix[0][1]) + (mat1.matrix[2][3] / mat2.matrix[0][2]) + (mat1.matrix[3][3] / mat2.matrix[0][3]);
		
		m.matrix[1][0] = (mat1.matrix[0][0] / mat2.matrix[1][0]) + (mat1.matrix[1][0] / mat2.matrix[1][1]) + (mat1.matrix[2][0] / mat2.matrix[1][2]) + (mat1.matrix[3][0] / mat2.matrix[1][3]);
		m.matrix[1][1] = (mat1.matrix[0][1] / mat2.matrix[1][0]) + (mat1.matrix[1][1] / mat2.matrix[1][1]) + (mat1.matrix[2][1] / mat2.matrix[1][2]) + (mat1.matrix[3][1] / mat2.matrix[1][3]);
		m.matrix[1][2] = (mat1.matrix[0][2] / mat2.matrix[1][0]) + (mat1.matrix[1][2] / mat2.matrix[1][1]) + (mat1.matrix[2][2] / mat2.matrix[1][2]) + (mat1.matrix[3][2] / mat2.matrix[1][3]);
		m.matrix[1][3] = (mat1.matrix[0][3] / mat2.matrix[1][0]) + (mat1.matrix[1][3] / mat2.matrix[1][1]) + (mat1.matrix[2][3] / mat2.matrix[1][2]) + (mat1.matrix[3][3] / mat2.matrix[1][3]);
		
		m.matrix[2][0] = (mat1.matrix[0][0] / mat2.matrix[2][0]) + (mat1.matrix[1][0] / mat2.matrix[2][1]) + (mat1.matrix[2][0] / mat2.matrix[2][2]) + (mat1.matrix[3][0] / mat2.matrix[2][3]);
		m.matrix[2][1] = (mat1.matrix[0][1] / mat2.matrix[2][0]) + (mat1.matrix[1][1] / mat2.matrix[2][1]) + (mat1.matrix[2][1] / mat2.matrix[2][2]) + (mat1.matrix[3][1] / mat2.matrix[2][3]);
		m.matrix[2][2] = (mat1.matrix[0][2] / mat2.matrix[2][0]) + (mat1.matrix[1][2] / mat2.matrix[2][1]) + (mat1.matrix[2][2] / mat2.matrix[2][2]) + (mat1.matrix[3][2] / mat2.matrix[2][3]);
		m.matrix[2][3] = (mat1.matrix[0][3] / mat2.matrix[2][0]) + (mat1.matrix[1][3] / mat2.matrix[2][1]) + (mat1.matrix[2][3] / mat2.matrix[2][2]) + (mat1.matrix[3][3] / mat2.matrix[2][3]);
	
		m.matrix[3][0] = (mat1.matrix[0][0] / mat2.matrix[3][0]) + (mat1.matrix[1][0] / mat2.matrix[3][1]) + (mat1.matrix[2][0] / mat2.matrix[3][2]) + (mat1.matrix[3][0] / mat2.matrix[3][3]);
		m.matrix[3][1] = (mat1.matrix[0][1] / mat2.matrix[3][0]) + (mat1.matrix[1][1] / mat2.matrix[3][1]) + (mat1.matrix[2][1] / mat2.matrix[3][2]) + (mat1.matrix[3][1] / mat2.matrix[3][3]);
		m.matrix[3][2] = (mat1.matrix[0][2] / mat2.matrix[3][0]) + (mat1.matrix[1][2] / mat2.matrix[3][1]) + (mat1.matrix[2][2] / mat2.matrix[3][2]) + (mat1.matrix[3][2] / mat2.matrix[3][3]);
		m.matrix[3][3] = (mat1.matrix[0][3] / mat2.matrix[3][0]) + (mat1.matrix[1][3] / mat2.matrix[3][1]) + (mat1.matrix[2][3] / mat2.matrix[3][2]) + (mat1.matrix[3][3] / mat2.matrix[3][3]);

		return m;
	}
	
	public void add(Matrix4 mat) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] += mat.matrix[i][j];
			}
		}
	}
	
	public void subtract(Matrix4 mat) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] -= mat.matrix[i][j];
			}
		}
	}
}
