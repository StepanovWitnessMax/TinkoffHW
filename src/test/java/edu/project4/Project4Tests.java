package edu.project4;

import edu.project4.PostProcessing.GammaLogImageProcessor;
import edu.project4.PostProcessing.ImageProcessor;
import edu.project4.Renderers.FractalRenderer;
import edu.project4.Renderers.MultiThreadFractalRenderer;
import edu.project4.Renderers.SingleThreadFractalRenderer;
import edu.project4.Transformations.HorseShoeTransformation;
import edu.project4.Transformations.PopcornTransformation;
import edu.project4.Transformations.SphereTransformation;
import edu.project4.Transformations.Transformation;
import edu.project4.shared.FractalImage;
import edu.project4.shared.ImageFormat;
import edu.project4.shared.ImageUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class Project4Tests {

    @Test
    void singleThreadSmallTest() {
        FractalImage fractalImage = FractalImage.create(1920, 1080);
        FractalRenderer renderer = new SingleThreadFractalRenderer();

        // Setting functions
        List<Transformation> transformationArrayList = new ArrayList<>();
        transformationArrayList.add(new SphereTransformation());

        // rendering
        Random random = new Random();
        fractalImage = renderer.render(fractalImage, transformationArrayList, 30, 60000, 2, random.nextLong());

        // post processing
        ImageProcessor imageProcessor = new GammaLogImageProcessor();
        imageProcessor.process(fractalImage);

        // save to filesystem
        ImageUtils.save(fractalImage, "project4/singleSmallImage.png", ImageFormat.PNG);
    }

    @Test
    void multiThreadSmallTest() {
        FractalImage fractalImage = FractalImage.create(1920, 1080);
        FractalRenderer renderer = new MultiThreadFractalRenderer(4);

        // Setting functions
        List<Transformation> transformationArrayList = new ArrayList<>();
        transformationArrayList.add(new SphereTransformation());

        // rendering
        Random random = new Random();
        fractalImage = renderer.render(fractalImage, transformationArrayList, 30, 60000, 2, random.nextLong());

        // post processing
        ImageProcessor imageProcessor = new GammaLogImageProcessor();
        imageProcessor.process(fractalImage);

        // save to filesystem
        ImageUtils.save(fractalImage, "project4/multiSmallImage.png", ImageFormat.PNG);
    }

    @Test
    void singleThreadBigTest() {
        FractalImage fractalImage = FractalImage.create(2560, 1440);
        FractalRenderer renderer = new SingleThreadFractalRenderer();

        // Setting functions
        List<Transformation> transformationArrayList = new ArrayList<>();
        transformationArrayList.add(new SphereTransformation());
        transformationArrayList.add(new HorseShoeTransformation());
        transformationArrayList.add(new PopcornTransformation());

        // rendering
        Random random = new Random();
        fractalImage = renderer.render(fractalImage, transformationArrayList, 30, 600000, 4, random.nextLong());

        // post processing
        ImageProcessor imageProcessor = new GammaLogImageProcessor();
        imageProcessor.process(fractalImage);

        // save to filesystem
        ImageUtils.save(fractalImage, "project4/singleBigImage.png", ImageFormat.PNG);
    }

    @Test
    void multiThreadBigTest() {
        FractalImage fractalImage = FractalImage.create(2560, 1440);
        FractalRenderer renderer = new MultiThreadFractalRenderer(4);

        // Setting functions
        List<Transformation> transformationArrayList = new ArrayList<>();
        transformationArrayList.add(new SphereTransformation());
        transformationArrayList.add(new HorseShoeTransformation());
        transformationArrayList.add(new PopcornTransformation());

        // rendering
        Random random = new Random();
        fractalImage = renderer.render(fractalImage, transformationArrayList, 30, 600000, 4, random.nextLong());

        // post processing
        ImageProcessor imageProcessor = new GammaLogImageProcessor();
        imageProcessor.process(fractalImage);

        // save to filesystem
        ImageUtils.save(fractalImage, "project4/multiBigImage.png", ImageFormat.PNG);
    }
}
