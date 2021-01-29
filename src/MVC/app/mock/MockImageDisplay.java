package MVC.app.mock;

import MVC.model.Image;
import MVC.view.ImageDisplay;

public class MockImageDisplay implements ImageDisplay{
    
    private Image image;
    
    @Override
    public void display(Image image){
        this.image = image;
        System.out.println(image.getName());
    }
    
    @Override
    public Image current(){
        return this.image;
    }
            
    
}
