package math;

public class Matrix3 {

	public float[][] matrix;
	
	public static Matrix3 add(Matrix3 mat1, Matrix3 mat2) {
		return add(mat1, mat2);
	}
	
	public static Matrix3 subtract(Matrix3 mat1, Matrix3 mat2) {
		return subtract(mat1, mat2);
	}
	
	public Matrix3() {
		matrix = new float[3][3];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = 0;
			}
		}
	}

	public static Matrix3 multiply(Matrix3 mat1, Matrix3 mat2) {
		Matrix3 m = new Matrix3();
		m.matrix[0][0] = (mat1.matrix[0][0] * mat2.matrix[0][0]) + (mat1.matrix[1][0] * mat2.matrix[0][1]) + (mat1.matrix[2][0] * mat2.matrix[0][2]);
		m.matrix[0][1] = (mat1.matrix[0][1] * mat2.matrix[0][0]) + (mat1.matrix[1][1] * mat2.matrix[0][1]) + (mat1.matrix[2][1] * mat2.matrix[0][2]);
		m.matrix[0][2] = (mat1.matrix[0][2] * mat2.matrix[0][0]) + (mat1.matrix[1][2] * mat2.matrix[0][1]) + (mat1.matrix[2][2] * mat2.matrix[0][2]);
		
		m.matrix[1][0] = (mat1.matrix[0][0] * mat2.matrix[1][0]) + (mat1.matrix[1][0] * mat2.matrix[1][1]) + (mat1.matrix[2][0] * mat2.matrix[1][2]);
		m.matrix[1][1] = (mat1.matrix[0][1] * mat2.matrix[1][0]) + (mat1.matrix[1][1] * mat2.matrix[1][1]) + (mat1.matrix[2][1] * mat2.matrix[1][2]);
		m.matrix[1][2] = (mat1.matrix[0][2] * mat2.matrix[1][0]) + (mat1.matrix[1][2] * mat2.matrix[1][1]) + (mat1.matrix[2][2] * mat2.matrix[1][2]);
		
		m.matrix[2][0] = (mat1.matrix[0][0] * mat2.matrix[2][0]) + (mat1.matrix[1][0] * mat2.matrix[2][1]) + (mat1.matrix[2][0] * mat2.matrix[2][2]);
		m.matrix[2][1] = (mat1.matrix[0][1] * mat2.matrix[2][0]) + (mat1.matrix[1][1] * mat2.matrix[2][1]) + (mat1.matrix[2][1] * mat2.matrix[2][2]);
		m.matrix[2][2] = (mat1.matrix[0][2] * mat2.matrix[2][0]) + (mat1.matrix[1][2] * mat2.matrix[2][1]) + (mat1.matrix[2][2] * mat2.matrix[2][2]);
		return m;
	}
	
	public static Matrix3 divide(Matrix3 mat1, Matrix3 mat2) {
		Matrix3 m = new Matrix3();
		m.matrix[0][0] = (mat1.matrix[0][0] / mat2.matrix[0][0]) + (mat1.matrix[1][0] / mat2.matrix[0][1]) + (mat1.matrix[2][0] / mat2.matrix[0][2]);
		m.matrix[0][1] = (mat1.matrix[0][1] / mat2.matrix[0][0]) + (mat1.matrix[1][1] / mat2.matrix[0][1]) + (mat1.matrix[2][1] / mat2.matrix[0][2]);
		m.matrix[0][2] = (mat1.matrix[0][2] / mat2.matrix[0][0]) + (mat1.matrix[1][2] / mat2.matrix[0][1]) + (mat1.matrix[2][2] / mat2.matrix[0][2]);
		
		m.matrix[1][0] = (mat1.matrix[0][0] / mat2.matrix[1][0]) + (mat1.matrix[1][0] / mat2.matrix[1][1]) + (mat1.matrix[2][0] / mat2.matrix[1][2]);
		m.matrix[1][1] = (mat1.matrix[0][1] / mat2.matrix[1][0]) + (mat1.matrix[1][1] / mat2.matrix[1][1]) + (mat1.matrix[2][1] / mat2.matrix[1][2]);
		m.matrix[1][2] = (mat1.matrix[0][2] / mat2.matrix[1][0]) + (mat1.matrix[1][2] / mat2.matrix[1][1]) + (mat1.matrix[2][2] / mat2.matrix[1][2]);
		
		m.matrix[2][0] = (mat1.matrix[0][0] / mat2.matrix[2][0]) + (mat1.matrix[1][0] / mat2.matrix[2][1]) + (mat1.matrix[2][0] / mat2.matrix[2][2]);
		m.matrix[2][1] = (mat1.matrix[0][1] / mat2.matrix[2][0]) + (mat1.matrix[1][1] / mat2.matrix[2][1]) + (mat1.matrix[2][1] / mat2.matrix[2][2]);
		m.matrix[2][2] = (mat1.matrix[0][2] / mat2.matrix[2][0]) + (mat1.matrix[1][2] / mat2.matrix[2][1]) + (mat1.matrix[2][2] / mat2.matrix[2][2]);
		return m;
	}
	
	public void add(Matrix3 mat) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] += mat.matrix[i][j];
			}
		}
	}
	
	public void subtract(Matrix3 mat) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] -= mat.matrix[i][j];
			}
		}
	}
	
}
