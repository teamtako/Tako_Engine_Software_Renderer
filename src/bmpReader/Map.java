package bmpReader;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

 class Map {
 String file;
 boolean Alpha;
 byte turn[];
 byte pic[][][];
 int height;
 int width;
Map(String path) throws IOException{
	//ArrayList<Byte> ListData= new ArrayList<Byte>();
	BufferedImage img = ImageIO.read(new File(path));
	final int w = img.getWidth();
	final int h = img.getHeight();
	width=w;
	height=h;
	System.out.println(path+" has been loaded with a size of "+w+"/"+h);
	 pic = new byte[w][h][4];
	 turn = new byte[w*h*4];
	//creates layers separately
	byte[][] red = new byte[w][h];
	byte[][] green = new byte[w][h];
	byte[][] blue = new byte[w][h];
	byte[][] alpha = new byte[w][h];
	System.out.println("1");
	//scans image rgba and isolates layers
	for(int x=0; x<w; x++){
	  for(int y=0; y<h; y++){
	     int color = img.getRGB(x,y);
	     alpha[x][y] = (byte)(color>>24);
	     red[x][y] = (byte)(color>>16);
	     green[x][y] = (byte)(color>>8);
	     blue[x][y] = (byte)(color);
	  }
	}
	System.out.println("2");

	//puts all layers into 1 3d array
	//Key for pic:
	//pic[x location of pixel][y loc of pixel][layer number(0=r,1=green,2=blue,3=alpha)]
	for (int i = 0; i < w; i++) {
		for (int j = 0; j < h; j++) {
			
				pic[i][j][0]=red[i][j];
				pic[i][j][1]=green[i][j];
				pic[i][j][2]=blue[i][j];
				pic[i][j][3]=alpha[i][j];
				
		}
	} 
	System.out.println("3");

	//condenses 3d array into 1d array with 4x the size and organized linearly
	int p=0;
	for (byte[][] bs : pic) {
		for (byte[] bs2 : bs) {
			for (byte bs3 : bs2) {
				turn[p]=(byte)Byte.toUnsignedInt(bs3);
				p++;
			}
		}
	}
		
	System.out.println("4");

}
public void textDisplay() {
	for (int i = 0; i < turn.length; i++) {
		if(i%4==0) {
			System.out.print("|");

		}
		if(i%(width*4)==0) {
			System.out.print("\n");
		}
		System.out.print(Byte.toUnsignedInt(turn[i])+",");
	}
}
public float[] getPixAt(float x, float y) {
	//float converX
	//float converY

	return null;

}


public byte[] cropTri(int x1,int y1,int x2,int y2,int x3,int y3){
	Boolean[][] visMap = new Boolean[width][height];
	Boolean[][] pointer = new Boolean[width][height];

	for (int i = 0; i < width;i++) {
		for (int j = 0; j < height; j++) {
			visMap[i][j]=false;
			System.out.print(i+"/"+j+" ");
		}
		System.out.println();
	}
	visMap[x1][y1]=true;
	visMap[x2][y2]=true;
	visMap[x3][y3]=true;
	
//
	double slope12=((double)y2-y1)/((double)x2-x1);
	double slope23=((double)y2-y3)/((double)x2-x3);
	double slope13=((double)y1-y3)/((double)x1-x3);

	System.out.println("slope from point 1 to point 2 is: "+slope12+"\nslope from point 2 to point 3 is: "+slope23+"\nslope from point 1 to point 3 is: "+slope13);
for (int i = 0; i < width; i++) {
if(y1+(slope13*i)>height) {
		
	}else
	visMap[x1+i][(int) (y1+slope12)]=true;
}
for (int i = 0; i < width; i++) {
if(y1+(slope13*i)>height) {
		
	}else
	visMap[x2+i][(int) (y2+slope23)]=true;
}
for (int i = 0; i < width; i++) {
	if(y1+(slope13*i)>height) {
		
	}else {
	visMap[x1+i][(int) (y1+(slope13*i))]=true;
	}
}
	
	//visual
		for (int i = 0; i < visMap.length; i++) {
			for (int j = 0; j < visMap.length; j++) {	
				if(!visMap[i][j]) {
					System.out.print("--- ");
				}else {
					System.out.print("### ");
				}
				//System.out.print(Byte.toUnsignedInt(visMap[i][j])+" ");
			}
			System.out.println("\n");
		}
		//vis
	return turn;
}

 }
