package util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

	public class CustomJPanel extends JPanel {
		JFrame jf = new JFrame("体系结构风格");
		BufferedImage bufferedImage;
		Image image;
		File file;

		public File getFile() {
			return file;
		}

		public void setFile(File file) {
			this.file = file;
		}

		public CustomJPanel(){
			jf.setSize(500,500);
			jf.add(this);
			jf.setVisible(true);
		}

		public void paint(Graphics g) {
			// 读取图片
			try {
				bufferedImage = ImageIO.read(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			image = (Image)bufferedImage;    // 转换
			g.drawImage(image,50,50,null);  // 显示
			//g.clearRect(0,0,500,500);               // 清空画布
		}

	}

