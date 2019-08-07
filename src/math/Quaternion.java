package math;

public class Quaternion {
	
	public float x;
	public float y;
	public float z;
	public float w;
	
	// NOTE (Charlie): Builds a Quaternion from inputed values
	public Quaternion(float x, float y, float z, float w)
	{
		this.x = x; this.y = y; this.z = z; this.w = w;
	}
	
	public static Quaternion multiply(Quaternion q1, Quaternion q2)
	{
		//NOTE (Charlie): Multiply q1's 'q' variables by q2's 'q' variables (Do not touch please!)
		float w = q1.w * q2.w - q1.x * q2.x - q1.y * q2.y - q1.z * q2.z;
		float x = q1.w * q2.x + q1.x * q2.w + q1.y * q2.z - q1.z * q2.y;
		float y = q1.w * q2.y - q1.x * q2.z + q1.y * q2.w + q1.z * q2.x;
		float z = q1.w * q2.z + q1.x * q2.y - q1.y * q2.x + q1.z * q2.w;
		
		return new Quaternion(x,y,z,w);
	}
	
	public void multiply(Quaternion q1)
	{
		this.clone(multiply(this,q1));
		
	}
	
	//NOTE (Charlie): Adds 'q' variables together from 2 Quaternions
	public static Quaternion add(Quaternion q1, Quaternion q2)
	{
		return new Quaternion(q1.x + q2.x,q1.y + q2.y,q1.z + q2.z,q1.w + q2.w);
	}
	public Quaternion add(Quaternion q1) {
        return add(this, q1);
    }
	
	//NOTE (Charlie): Subtracts 'q' variables from 2 Quaternions from each other 
	public static Quaternion subtract(Quaternion q1, Quaternion q2)
	{
		return new Quaternion(q1.x - q2.x,q1.y - q2.y,q1.z - q2.z,q1.w - q2.w);
	}
	public Quaternion subtract(Quaternion q1) {
        return subtract(this, q1);
    }
	
	//NOTE (Charlie): clones passed Quaternion's values to current Quaternion
	public void clone(Quaternion q1)
	{
		this.x = q1.x;
		this.y = q1.y;
		this.z = q1.z;
		this.w = q1.w;
	}
	
	//NOTE (Charlie): converts a rotation to a Quaternion
	public static Quaternion rotationToQuaternion(Vector3 axis, float angle) 
	{
	    axis.normalize();
	    
		float hang = angle/2f;
		float sinHang = (float)Math.sin(hang);
		Quaternion q1 = new Quaternion(axis.x * sinHang,axis.y * sinHang,axis.z * sinHang,(float)Math.cos(hang));
		q1.normalize(); 
		return q1; 
	}
	
	//NOTE (Charlie): rotates a quaternion around (Vector 3 axis) for (float angle) degrees
	public void rotate(Vector3 axis, float angle)
	{
		Quaternion q1 = rotationToQuaternion(axis, angle);
		multiply(q1);
		
	}
	
	//NOTE (Charlie): converts current Quaternion to a Matrix4
	public Matrix4 toMatrix()
	{
		this.normalize();
		Matrix4 m4 = new Matrix4();
		//Attempt 2:
	   /* float sqw = this.w*this.w;
	    float sqx = this.x*this.x;
	    float sqy = this.y*this.y;
	    float sqz = this.z*this.z;
	    // invs (inverse square length) is only required if quaternion is not already normalised
	    float invs = 1 / (sqx + sqy + sqz + sqw);
	    m4.matrix[0][0] = ( sqx - sqy - sqz + sqw)*invs ; // since sqw + sqx + sqy + sqz =1/invs*invs
	    m4.matrix[1][1] = (-sqx + sqy - sqz + sqw)*invs ;
	    m4.matrix[2][2] = (-sqx - sqy + sqz + sqw)*invs ;
	    
	    float tmp1 = this.x*this.y;
	    float tmp2 = this.z*this.w;
	    m4.matrix[0][1] = 2.0f * (tmp1 + tmp2)*invs ;
	    m4.matrix[1][0] = 2.0f * (tmp1 - tmp2)*invs ;
	    
	    tmp1 = this.x*this.z;
	    tmp2 = this.y*this.w;
	    m4.matrix[0][2] = 2.0f * (tmp1 - tmp2)*invs ;
	    m4.matrix[2][0] = 2.0f * (tmp1 + tmp2)*invs ;
	    tmp1 = this.y*this.z;
	    tmp2 = this.x*this.w;
	    m4.matrix[1][2] = 2.0f * (tmp1 + tmp2)*invs ;
	    m4.matrix[2][1] = 2.0f * (tmp1 - tmp2)*invs ;
	    m4.matrix[3][3] = 1f; */
		//Attempt 1:
		m4.matrix[0][0] = (1 - (2*(this.y * this.y)) - (2*(this.z * this.z)));
		m4.matrix[0][1] = ((2*this.x * this.y) + (2*this.z * this.w));
		m4.matrix[0][2] = ((2*this.x * this.z) - (2*this.y * this.w));
		m4.matrix[0][3] = 0;
		m4.matrix[1][0] = ((2*this.x * this.y) - (2*this.z * this.w));
		m4.matrix[1][1] = (1 - (2*(this.x * this.x)) - (2*(this.z * this.z)));
		m4.matrix[1][2] = ((2*this.y * this.z) + (2*this.x * this.w));
		m4.matrix[1][3] = 0;
		m4.matrix[2][0] = ((2*this.x * this.z) + (2*this.y * this.w));
		m4.matrix[2][1] = ((2*this.y * this.z) - (2*this.x * this.w));
		m4.matrix[2][2] = (1 - (2*(this.x * this.x)) - (2*(this.y * this.y)));
		m4.matrix[2][3] = 0;
		m4.matrix[3][0] = 0;
		m4.matrix[3][1] = 0;
		m4.matrix[3][2] = 0;
		m4.matrix[3][3] = 1; 
		//Attempt 3:
		/*Matrix4 mat41 = new Matrix4(this.w);
		Matrix4 mat42 = new Matrix4(this.w);
		//NOTE (Charlie): Equation from Euclideanspace, mat41 is left side, m42 is right side
		mat41.matrix[1][0] = this.z; mat42.matrix[1][0] = this.z;
		mat41.matrix[2][0] = -this.y; mat42.matrix[2][0] = -this.y;
		mat41.matrix[3][0] = this.x; mat42.matrix[1][0] = -this.x;
		mat41.matrix[0][1] = -this.z; mat42.matrix[0][1] = -this.z;
		mat41.matrix[2][1] = this.x; mat42.matrix[2][1] = this.x;
		mat41.matrix[3][1] = this.y; mat42.matrix[3][1] = -this.y;
		mat41.matrix[0][2] = this.y; mat42.matrix[0][2] = this.y;
		mat41.matrix[1][2] = -this.x; mat42.matrix[1][2] = -this.x;
		mat41.matrix[3][2] = this.z; mat42.matrix[3][2] = -this.z;
		mat41.matrix[0][3] = -this.x; mat42.matrix[0][3] = this.x;
		mat41.matrix[1][3] = -this.y; mat42.matrix[0][3] = this.y;
		mat41.matrix[2][3] = -this.z; mat42.matrix[2][3] = this.z;
		return Matrix4.multiply(mat41, mat42);*/
		return m4; 
	}
	
	
	
	
	public float length()
	{
		return (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
	}
	
	//NOTE (Charlie): normalizes a Quaternion's length
	public void normalize()
	{
		float length = length();
		if (length == 0) {
            return;
        }
		x = x / length; y = y / length; z = z / length; w = w / length;
	
	}
	
	
}