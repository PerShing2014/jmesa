/*
 * Copyright 2004 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jmesa.core.preference;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.jmesa.web.WebContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 2.0
 * @author Jeff Johnston
 */
public class PropertiesPreferences implements Preferences {
    private Logger logger = LoggerFactory.getLogger(PropertiesPreferences.class);

    private final static String JMESA_PROPERTIES = "jmesa.properties";

    private Properties properties = new Properties();

    public PropertiesPreferences(String preferencesLocation, WebContext webContext) {
        try {
            InputStream resourceAsStream = getInputStream(JMESA_PROPERTIES, webContext);
            properties.load(resourceAsStream);
            if (StringUtils.isNotBlank(preferencesLocation)) {
                InputStream input = getInputStream(preferencesLocation, webContext);
                if (input != null) {
                    properties.load(input);
                }
            }
        } catch (IOException e) {
            logger.error("Could not load the JMesa preferences.", e);
        }
    }

    private InputStream getInputStream(String preferencesLocation, WebContext webContext)
            throws IOException {
        if (preferencesLocation.startsWith("WEB-INF")) {
            String path = webContext.getRealPath("WEB-INF");
            String name = StringUtils.substringAfter(preferencesLocation, "WEB-INF/");
            return new FileInputStream(path + "/" + name);
        }

        return this.getClass().getResourceAsStream(preferencesLocation);
    }

    /**
     * Get the property.
     */
    public String getPreference(String name) {
        return (String) properties.get(name);
    }
}
