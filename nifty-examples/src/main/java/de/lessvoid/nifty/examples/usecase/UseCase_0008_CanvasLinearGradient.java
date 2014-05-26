package de.lessvoid.nifty.examples.usecase;

import de.lessvoid.nifty.api.ChildLayout;
import de.lessvoid.nifty.api.Nifty;
import de.lessvoid.nifty.api.NiftyCanvas;
import de.lessvoid.nifty.api.NiftyCanvasPainter;
import de.lessvoid.nifty.api.NiftyColor;
import de.lessvoid.nifty.api.NiftyLinearGradient;
import de.lessvoid.nifty.api.NiftyNode;
import de.lessvoid.nifty.api.UnitValue;

/**
 * Test a custom canvas painter.
 * @author void
 */
public class UseCase_0008_CanvasLinearGradient implements UseCaseUpdateable {
  private final NiftyNode niftyNode;
  private final NiftyNode child;
  private float totalTime;

  public UseCase_0008_CanvasLinearGradient(final Nifty nifty) {
    niftyNode = nifty.createRootNode(UnitValue.px(400), UnitValue.px(400), ChildLayout.Center);
    niftyNode.setBackgroundColor(NiftyColor.TRANSPARENT());

    child = niftyNode.newChildNode(UnitValue.percent(100), UnitValue.percent(100));
    child.setBackgroundColor(NiftyColor.RED());
    child.setContent(new NiftyCanvasPainter() {
      @Override
      public void paint(final NiftyNode node, final NiftyCanvas canvas) {
        canvas.setFillStyle(NiftyColor.BLUE());
        canvas.fillRect(0, 0, node.getWidth(), node.getHeight());

        NiftyLinearGradient gradient = new NiftyLinearGradient(50, 50, 400, 150);
        gradient.addColorStop(0.0, NiftyColor.RED());
        gradient.addColorStop(1.0, NiftyColor.BLACK());
        canvas.setFillStyle(gradient);
        canvas.fillRect(50, 50, 400, 150);
      }
    });
  }

  @Override
  public void update(final Nifty nifty, final float deltaTime) {
    totalTime += deltaTime;

    if (totalTime > 5) {
      child.requestRedraw();
      totalTime = 0;
    }
  }

  public static void main(final String[] args) throws Exception {
    UseCaseRunner.run(UseCase_0008_CanvasLinearGradient.class, args);
  }
}