package allometry.graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

/**
 * Scoreboard is a class for assembling individual scoreboards with widgets
 * in a canvas space.
 * 
 * @author allometry
 * @version 1.0
 * @since 1.0
 */
public class Scoreboard {
	public static final int TOP_LEFT = 1, TOP_RIGHT = 2, BOTTOM_LEFT = 3, BOTTOM_RIGHT = 4;
	public static final int gameCanvasTop = 25, gameCanvasLeft = 25, gameCanvasBottom = 309, gameCanvasRight = 487;

	private ImageObserver observer = null;

	private int scoreboardLocation, scoreboardX, scoreboardY, scoreboardWidth,
	scoreboardHeight, scoreboardArc;

	private ArrayList<ScoreboardWidget> widgets = new ArrayList<ScoreboardWidget>();

	/**
	 * Creates a new instance of Scoreboard.
	 * 
	 * @param scoreboardLocation	the location of where the scoreboard should be drawn on the screen
	 * 								@see Scoreboard.TOP_LEFT
	 * 								@see Scoreboard.TOP_RIGHT
	 * 								@see Scoreboard.BOTTOM_LEFT
	 * 								@see Scoreboard.BOTTOM_RIGHT
	 * @param width					the pixel width of the scoreboard
	 * @param arc					the pixel arc of the scoreboard rounded rectangle
	 * @since 1.0
	 */
	public Scoreboard(int scoreboardLocation, int width, int arc) {
		this.scoreboardLocation = scoreboardLocation;
		scoreboardHeight = 10;
		scoreboardWidth = width;
		scoreboardArc = arc;

		switch (scoreboardLocation) {
		case 1:
			scoreboardX = gameCanvasLeft;
			scoreboardY = gameCanvasTop;
			break;

		case 2:
			scoreboardX = gameCanvasRight - scoreboardWidth;
			scoreboardY = gameCanvasTop;
			break;

		case 3:
			scoreboardX = gameCanvasLeft;
			break;

		case 4:
			scoreboardX = gameCanvasRight - scoreboardWidth;
			break;
		}
	}

	/**
	 * Adds a ScoreboardWidget to the Scoreboard.
	 * 
	 * @param widget				an instance of a ScoreboardWidget containing an image
	 * 								and text
	 * 								@see ScoreboardWidget
	 * @return						true if the widget was added to Scoreboard
	 * @since 1.0
	 */
	public boolean addWidget(ScoreboardWidget widget) {
		return widgets.add(widget);
	}

	/**
	 * Gets a ScoreboardWidget by it's index within Scoreboard.
	 * 
	 * @param widgetIndex			the index of the ScoreboardWidget
	 * @return						an instance of ScoreboardWidget
	 * @since 1.0
	 */
	public ScoreboardWidget getWidget(int widgetIndex) {
		try {
			return widgets.get(widgetIndex);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Gets the Scoreboard widgets.
	 * 
	 * @return						an ArrayList filled with ScoreboardWidget's
	 */
	public ArrayList<ScoreboardWidget> getWidgets() {
		return widgets;
	}

	/**
	 * Draws the Scoreboard and ScoreboardWidget's to an instances of Graphics2D.
	 * 
	 * @param g						an instance of Graphics2D
	 * @return						true if Scoreboard was able to draw to the Graphics2D instance and false if it wasn't
	 * @since 1.0
	 */
	public boolean drawScoreboard(Graphics2D g) {
		try {
			if(scoreboardHeight <= 10) {
				for (ScoreboardWidget widget : widgets) {
					scoreboardHeight += widget.getWidgetImage().getHeight(observer) + 4;
				}
			}

			if (scoreboardLocation == 3 || scoreboardLocation == 4) {
				scoreboardY = gameCanvasBottom - scoreboardHeight;
			}

			RoundRectangle2D scoreboard = new RoundRectangle2D.Float(
					scoreboardX, scoreboardY, scoreboardWidth,
					scoreboardHeight, scoreboardArc, scoreboardArc);

			g.setColor(new Color(0, 0, 0, 127));
			g.fill(scoreboard);

			int x = scoreboardX + 5;
			int y = scoreboardY + 5;
			for (ScoreboardWidget widget : widgets) {
				widget.drawWidget(g, x, y);
				y += widget.getWidgetImage().getHeight(observer) + 4;
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Returns the height of the Scoreboard with respect to it's contained ScoreboardWidget's.
	 * 
	 * @return						the pixel height of the Scoreboard
	 * @since 1.0 
	 */
	public int getHeight() {
		return scoreboardHeight;
	}
}