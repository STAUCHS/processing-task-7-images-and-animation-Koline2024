import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

// Variable declarations here
PImage imgExplosion;
PImage imgBackground;
float fltExplosionX;
float fltExplosionY;
float fltVelocityX = 1;
float fltVelocityY = 0;
float fltEllipseX;
float fltEllipseY;
float fltEllipseVelocityX = 5;
float fltEllipseVelocityY = 5;
float fltAngle = 0;


  public void settings() {
    // Window size
    size(400, 400);
  }

  public void setup() {
    // Imports and resizes images
    imgExplosion = loadImage("blackSmoke00.png");
    imgExplosion.resize(50, 50);
    imgBackground = loadImage("mx2px4h5h8161.jpg");
    imgBackground.resize(width, height);
  }

  public void draw() {

    background(imgBackground);

    // Edge collision
    if (fltExplosionX > width - imgExplosion.width || fltExplosionX < 0) {
      fltVelocityX *= -1;
    } 
    if (fltExplosionY > height - imgExplosion.height || fltExplosionY < 0) {
      fltVelocityY *= -1;
    } 

    // Acceleration due to gravity, animates object
    float fltGravity = (float) 1;
    fltVelocityY = fltVelocityY + fltGravity;
    fltExplosionX = fltExplosionX + fltVelocityX;
    fltExplosionY = fltExplosionY + fltVelocityY;
    image(imgExplosion, fltExplosionX, fltExplosionY);
    
    // Edge collision for circle
    fill(0, 0, 0);
    if (fltEllipseX > width - 50 || fltEllipseX < 0) {
      fltEllipseVelocityX *= -1;
    } 

    // Wave motion animation
    fltAngle = fltAngle + (float) 0.1;
    fltEllipseX = fltEllipseVelocityX + fltEllipseX;
    fltEllipseY = (float) Math.sin(fltAngle) * 150;
    ellipse(fltEllipseX, fltEllipseY + 200, 50, 50);
  }
}