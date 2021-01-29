package MVC.control;

import MVC.model.Image;
import MVC.view.ImageDisplay;
import MVC.view.ImageLoader;
import java.util.List;

public class LoadCommand implements Command{
    
    private final ImageLoader loader;
    private final List<Image> imageList;
    private final ImageDisplay imageDisplay;

    public LoadCommand(ImageLoader loader, List<Image> imageList, ImageDisplay imageDisplay) {
        this.loader = loader;
        this.imageList = imageList;
        this.imageDisplay = imageDisplay;
    }
    
    public void execute(){
        this.imageList.clear();
        this.imageList.addAll(loader.load());
        imageDisplay.display(imageList.get(0));
    }
    
    
}
