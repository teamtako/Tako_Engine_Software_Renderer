package runner;

import math.Quaternion;

public class QuaternionTestRunner {
//Not for Use, Charlie will Delete me soon
	public static void main(String[] args) {
		QuaternionTestRunner runner = new QuaternionTestRunner();
		runner.run();
	}
	public void run() 
	{
		Quaternion q1 = new Quaternion(0,0,0,0);
		Quaternion q2 = new Quaternion(1,1,1,1);
		
		
		
		q1.normalize();
		System.out.println(q1.length());
		System.out.println(q1.q3 + q1.q2 + q1.q1 + q1.q0);
	}
}
