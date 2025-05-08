package org.example.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan("org.example")
//@ComponentScan({"  ","  ","  "})
public class SpringConfig {
}
