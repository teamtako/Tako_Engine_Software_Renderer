package runner;

import math.Matrix4;
import renderEngine.Display;

public class Runner {

	Display display;
	
	public Runner() {
		Matrix4 mat1 = new Matrix4();
		Matrix4 mat2 = new Matrix4();
		for (int i = 0; i < mat1.matrix.length; i++) {
			for (int j = 0; j < mat1.matrix[i].length; j++) {
				if(i % 2 == 0 && j % 2 == 0) {
					mat1.matrix[i][j] = 2;
				}else {
				mat1.matrix[i][j] = 1;
				}
				mat2.matrix[i][j] = 1;
			}
		}
		
		Matrix4 mat3 = Matrix4.multiply(mat1, mat2);
		
		for (int i = 0; i < mat1.matrix.length; i++) {
			for (int j = 0; j < mat1.matrix[i].length; j++) {
				System.out.print(mat1.matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < mat1.matrix.length; i++) {
			for (int j = 0; j < mat1.matrix[i].length; j++) {
				System.out.print(mat2.matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < mat1.matrix.length; i++) {
			for (int j = 0; j < mat1.matrix[i].length; j++) {
				System.out.print(mat3.matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		display = new Display(720, 720);
		display.clearBackBuffer(0, 0, 0, 1);
		display.swapBuffers();
	}
	
	public static void main(String[] args) {
		new Runner();
	}
	
}
