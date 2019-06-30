package math;

public class Quaternion {
	
	public float q0;
	public float q1;
	public float q2;
	public float q3;
	
	//Build Quaternion
	public Quaternion(float x, float y, float z, float w)
	{
		//Sets 'q' values to values recieved when a Quaternion is created
		this.q0 = x; this.q1 = y; this.q2 = z; this.q3 = w;
	}
	
	public static Quaternion multiply(Quaternion q1, Quaternion q2)
	{
		// Multiply q1's 'q' variables by q2's 'q' variables (Do not touch please!)
		float w = q1.q3 * q2.q3 - q1.q0 * q2.q0 - q1.q1 * q2.q1 - q1.q2 * q2.q2;
		float x = q1.q3 * q2.q0 + q1.q0 * q2.q3 + q1.q1 * q2.q2 - q1.q2 * q2.q1;
		float y = q1.q3 * q2.q1 - q1.q0 * q2.q2 + q1.q1 * q2.q3 + q1.q2 * q2.q0;
		float z = q1.q3 * q2.q2 + q1.q0 * q2.q1 - q1.q1 * q2.q0 + q1.q2 * q2.q3;
		
		return new Quaternion(x,y,z,w);
	}
	
	public void multiply(Quaternion q1)
	{
		this.clone(multiply(this,q1));
		
	}
	
	
	public static Quaternion add(Quaternion q1, Quaternion q2)
	{
		return new Quaternion(q1.q0 + q2.q0,q1.q1 + q2.q1,q1.q2 + q2.q2,q1.q3 + q2.q3);
	}
	public Quaternion add(Quaternion q1) {
        return add(this, q1);
    }
	
	public static Quaternion subtract(Quaternion q1, Quaternion q2)
	{
		return new Quaternion(q1.q0 - q2.q0,q1.q1 - q2.q1,q1.q2 - q2.q2,q1.q3 - q2.q3);
	}
	public Quaternion subtract(Quaternion q1) {
        return subtract(this, q1);
    }
	public void clone(Quaternion q1)
	{
		this.q0 = q1.q0;
		this.q1 = q1.q1;
		this.q2 = q1.q2;
		this.q3 = q1.q3;
	}
	
	static Quaternion rotationToQuaternion(Vector3 axis, float angle) 
	{
		float hang = angle/2;
		Quaternion q1 = new Quaternion(axis.x * (float)Math.sin(hang),axis.y * (float)Math.sin(hang),axis.z * (float)Math.sin(hang),(float)Math.cos(hang));
		q1.normalize(); 
		return q1; 
	}
	
	public void rotate(Vector3 axis, float angle)
	{
		Quaternion q1 = rotationToQuaternion(axis, angle);
		multiply(q1);
		
	}
	
	public Matrix4 toMatrix()
	{
		Matrix4 m4 = new Matrix4();
		m4.matrix[0][0] = 1 - 2*(this.q1 * this.q1) - 2*(this.q2 * this.q2);
		m4.matrix[1][0] = 2*this.q0 * this.q1 - 2*this.q2 * this.q3;
		m4.matrix[2][0] = 2*this.q0 * this.q1 + 2*this.q2 * this.q3;
		m4.matrix[3][0] = 0;
		m4.matrix[0][1] = 2*this.q0 * this.q1 + 2*this.q2 * this.q3;
		m4.matrix[1][1] = 1 - 2*(this.q1 * this.q1) - 2*(this.q2 * this.q2);
		m4.matrix[2][1] = 2*this.q0 * this.q1 - 2*this.q2 * this.q3;
		m4.matrix[3][1] = 0;
		m4.matrix[0][2] = 2*this.q0 * this.q1 - 2*this.q2 * this.q3;
		m4.matrix[1][2] = 2*this.q0 * this.q1 + 2*this.q2 * this.q3;
		m4.matrix[2][2] = 1 - 2*(this.q1 * this.q1) - 2*(this.q2 * this.q2);
		m4.matrix[3][2] = 0;
		m4.matrix[0][3] = 0;
		m4.matrix[1][3] = 0;
		m4.matrix[2][3] = 0;
		m4.matrix[3][3] = 1;
		return m4;
	}
	
	
	
	
	public float length()
	{
		return (float)Math.sqrt(q0 * q0 + q1 * q1 + q2 * q2 + q3 *q3);
	}
	
	public void normalize()
	{
		float length = length();
		if (length == 0) {
            return;
        }
		q0 = q0 / length; q1 = q1 / length; q2 = q2 / length; q3 = q3 / length;
	
	}
	
	
}
