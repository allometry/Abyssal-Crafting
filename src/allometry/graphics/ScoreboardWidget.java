package allometry.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

/**
 * ScoreboardWidget is a container intended for use with a Scoreboard. Scoreboards contain
 * an image and text, which are later drawn to an instance of Graphics2D.
 * 
 * @author allometry
 * @version 1.0
 * @since 1.0
 * @see Scoreboard
 */
public class ScoreboardWidget {
	private ImageObserver observer = null;
	private Image widgetImage;
	private String widgetText;

	/**
	 * Creates a new instance of ScoreboardWidget.
	 * 
	 * @param widgetImage			an instance of an Image. Recommended size is 16x16 pixels
	 * 								@see java.awt.Image
	 * @param widgetText			text to be shown on the right of the widgetImage
	 * @since 1.0
	 */
	public ScoreboardWidget(Image widgetImage, String widgetText) {
		this.widgetImage = widgetImage;
		this.widgetText = widgetText;
	}

	/**
	 * Gets the widget image.
	 * 
	 * @return						the Image of ScoreboardWidget
	 * 								@see java.awt.Image
	 * @since 1.0
	 */
	public Image getWidgetImage() {
		return widgetImage;
	}

	/**
	 * Sets the widget image.
	 * 
	 * @param widgetImage			an instance of an Image. Recommended size is 16x16 pixels
	 * 								@see java.awt.Image
	 * @since 1.0
	 */
	public void setWidgetImage(Image widgetImage) {
		this.widgetImage = widgetImage;
	}

	/**
	 * Gets the widget text.
	 * 
	 * @return						the text of ScoreboardWidget
	 * @since 1.0
	 */
	public String getWidgetText() {
		return widgetText;
	}

	/**
	 * Sets the widget text.
	 * 
	 * @param widgetText			text to be shown on the right of the widgetImage
	 * @since 1.0
	 */
	public void setWidgetText(String widgetText) {
		this.widgetText = widgetText;
	}

	/**
	 * Draws the ScoreboardWidget to an instance of Graphics2D.
	 * 
	 * @param g						an instance of Graphics2D
	 * @param x						horizontal pixel location of where to draw the widget 
	 * @param y						vertical pixel location of where to draw the widget
	 * @since 1.0
	 */
	public void drawWidget(Graphics2D g, int x, int y) {
		g.setColor(Color.white);
		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

		g.drawImage(widgetImage, x, y, observer);
		g.drawString(widgetText, x + widgetImage.getWidth(observer) + 4, y + 12);
	}
}