package io.github.ftincdev.mttransformer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Path;

public class MainTransformer {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainTransformer.class);

    public void transform(Path outputDir) {
        LOGGER.info("MT-Transformer started");
    }
}
