package Lighting;

import math.Vector3;
import math.Vector4;

public class Diffuse { 
	
	public static Vector3 calculateTriangleNormal(Vector3 v1,Vector3 v2,Vector3 v3) {
		float normalx;
		float normaly;
		float normalz;
		Vector3 U = Vector3.sub(v2,v1);
		Vector3 V = Vector3.sub(v3,v1);
		normalx = (U.y*V.z)-(U.z*V.y);
		normaly = (U.z*V.x)-(U.x*V.z);
		normalz = (U.x*V.y)-(U.y*V.x);
		System.out.println("NormalX: "+normalx);
		System.out.println("NormalY: "+normaly);
		System.out.println("NormalZ: "+normalz);
		return new Vector3(normalx,normaly,normalz);
	}
	public static Vector3 calculateTrianglCenter(Vector3 v1,Vector3 v2,Vector3 v3) {
		System.out.println("CenterX: "+(v1.x+v2.x+v3.x)/3);
		System.out.println("CenterY: "+(v1.y+v2.y+v3.y)/3);
		System.out.println("CenterZ: "+(v1.z+v2.z+v3.z)/3);
		return new Vector3((v1.x+v2.x+v3.x)/3,(v1.y+v2.y+v3.y)/3,(v1.z+v2.z+v3.z)/3);
		
	}
	public static Vector3 calculateLightVectorFromPoint(Light light,Vector3 v) {
		return Vector3.sub(light.pos,v);
	}
	public static float calculateAngleBetweenVectors(Vector3 triangleVector,Vector3 lightVector) {
		float triangleMagnatude = (float) Math.sqrt(triangleVector.x*triangleVector.x+triangleVector.y*triangleVector.y+triangleVector.z*triangleVector.z);
		float lightMagnatude = (float) Math.sqrt(lightVector.x*lightVector.x+lightVector.y*lightVector.y+lightVector.z*lightVector.z);
		float dot = triangleVector.x*lightVector.x+triangleVector.y*lightVector.y+triangleVector.z*lightVector.z;
		System.out.println("dot:"+dot);
		System.out.println("lightMagnatude:"+lightMagnatude);
		System.out.println("triangleMagnatude:"+triangleMagnatude);
		System.out.println("Angle: "+(Math.acos(dot/lightMagnatude*triangleMagnatude))*180/Math.PI);
		return (float) ((Math.acos(dot/lightMagnatude*triangleMagnatude))*180/Math.PI);
	}
	public static Vector4 calculateTraingleDiffuse(Vector3 v1,Vector3 v2,Vector3 v3,Light light,Vector4 v4) {
		Vector3 triangleNormalVector = Diffuse.calculateTriangleNormal(v1,v2,v3);
		Vector3 triangleCenter = Diffuse.calculateTrianglCenter(v1,v2,v3);
		Vector3 lightVector = Diffuse.calculateLightVectorFromPoint(light,triangleCenter);
		float angle = Diffuse.calculateAngleBetweenVectors(triangleNormalVector,lightVector);
		if(angle>90) {
			angle = 90;
		}
		return new Vector4(v4.x-(angle/90)*v4.x,v4.y-(angle/90)*v4.y,v4.z-(angle/90)*v4.z,v4.w);
	}
}
