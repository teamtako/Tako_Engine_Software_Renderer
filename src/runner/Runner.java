package runner;

import math.Matrix4;
import math.Vector2;
import math.Vector4;
import renderEngine.Display;

public class Runner {

	Display display;
	
	public Runner() {
		display = new Display(720, 720);
		display.clearBackBuffer(0, 0, 0, 1);
		display.renderTriangle(new Vector2(0f, 1f), new Vector2(-1f, 0.5f), new Vector2(1f, 1f), new Vector4(255f, 0, 0, 255f));		
		display.swapBuffers();
	}
	
	public static void main(String[] args) {
		new Runner();
	}
	public static void diffuseLightingTest(Display display) {
		Vector3 v1 = new Vector3(0.0f,0.0f,0.0f);
		Vector3 v2 = new Vector3(0.5f,1.0f,0.0f);
		Vector3 v3 = new Vector3(1.0f,0.0f,0.0f);
		
		Vector3 triangleNormalVector = Diffuse.calculateTriangleNormal(v1,v2,v3);
		Light light = new Light(0.5f,0.33333334f,-1.0f);
		Vector3 triangleCenter = Diffuse.calculateTrianglCenter(v1,v2,v3);
		Vector3 lightVector = Diffuse.calculateLightVectorFromPoint(light,triangleCenter);
		float degree = Diffuse.calculateAngleBetweenVectors(triangleNormalVector,lightVector);
	
		System.out.println("Angle: "+degree);
		System.out.println("Triangle Normal Vector");
		System.out.println(triangleNormalVector.x);
		System.out.println(triangleNormalVector.y);
		System.out.println(triangleNormalVector.z);	
		System.out.println("Triangle Center");
		System.out.println(triangleCenter.x);
		System.out.println(triangleCenter.y);
		System.out.println(triangleCenter.z);
		System.out.println("Light Vector");
		System.out.println(lightVector.x);
		System.out.println(lightVector.y);
		System.out.println(lightVector.z);
		
		display.renderTriangle(new Vector2(v1.x,v1.y),new Vector2(v2.x,v2.y),new Vector2(v3.x,v3.y),new Vector4(255-(degree/90)*255, 0, 0, 255f));
		display.renderTriangle(new Vector2((float)(triangleCenter.x-0.01),(float)(triangleCenter.y-0.01)),new Vector2(triangleCenter.x,triangleCenter.y),new Vector2((float)(triangleCenter.x+0.01),(float)(triangleCenter.y-0.01)),new Vector4(0, 255f, 0, 255f));
		display.renderTriangle(new Vector2((float)(light.pos.x-0.01),(float)(light.pos.y-0.01)),new Vector2(light.pos.x,light.pos.y),new Vector2((float)(light.pos.x+0.01),(float)(light.pos.y-0.01)),new Vector4(0, 0, 255f, 255f));
	}
	
}