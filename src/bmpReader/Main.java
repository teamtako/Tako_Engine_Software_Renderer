package bmpReader;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Main {
public static void main(String[] args) throws IOException {
Map map = new Map("yee.bmp");
map.textDisplay();
//map.cropTri(0, 0, 9, 0, 5, 9);
//for (int i = 0; i < map.turn.length; i++) {
//	System.out.print(Byte.toUnsignedInt(map.turn[i]));
//}
}
}
//public byte[] getByte(String bmpLoc) throws IOException {
//	ArrayList<Byte> ListData= new ArrayList<Byte>();
//	BufferedImage img = ImageIO.read(new File(bmpLoc));
//	
//	final int w = img.getWidth();
//	final int h = img.getHeight();
//	System.out.println(w+"/"+h);
//	byte[][][] pic = new byte[w][h][4];
//
//	//all 
//	byte[][] red = new byte[w][h];
//	byte[][] green = new byte[w][h];
//	byte[][] blue = new byte[w][h];
//	byte[][] alpha = new byte[w][h];
//	
//	for(int x=0; x<w; x++){
//	  for(int y=0; y<h; y++){
//	     int color = img.getRGB(x,y);
//	     alpha[x][y] = (byte)(color>>24);
//	     red[x][y] = (byte)(color>>16);
//	     green[x][y] = (byte)(color>>8);
//	     blue[x][y] = (byte)(color);
//	  }
//	}
//	
//	//System.out.println(Byte.toUnsignedInt(red[0][0]));
//	
//	for (int i = 0; i < w; i++) {
//		for (int j = 0; j < h; j++) {
//			
//				pic[j][i][0]=red[i][j];
//				pic[j][i][1]=green[i][j];
//				pic[j][i][2]=blue[i][j];
//				pic[j][i][3]=alpha[i][j];
//				
//		}
//	} 
//	
////	for (int i = 0; i < w; i++) {
////		for (int j = 0; j < h; j++) {
////			pic[j][i][0]=red[i][j];
////			pic[j][i][1]=green[i][j];
////			pic[j][i][2]=blue[i][j];
////			pic[j][i][3]=alpha[i][j];
////			
////		}
////	}
//	int p=0;
//	byte[] turn = new byte[w*h*4];
//	for (byte[][] bs : pic) {
//		for (byte[] bs2 : bs) {
//			//System.out.print("(");
//			for (byte bs3 : bs2) {
//				//System.out.print(Byte.toUnsignedInt(bs3)+",");
//				turn[p]=(byte)Byte.toUnsignedInt(bs3);
//				//System.out.println(turn[p]);
//				p++;
//				
//			}
//			//System.out.print(")");
//		}
//		//System.out.print("\n");
//	}
//	
////	for (byte[][] bs : pic) {
////		for (byte[] bs2 : bs) {
////			System.out.print("(");
////			for (byte bs3 : bs2) {
////				System.out.print(Byte.toUnsignedInt(bs3)+",");
////				//System.out.println(bs3);
////				
////			}
////			System.out.print(")");
////		}
////		System.out.print("\n");
////	}
//
//for (int i = 0; i < turn.length; i++) {
//	System.out.println(Byte.toUnsignedInt(turn[i]));
//}			
//	return turn;
//	
//}
//}