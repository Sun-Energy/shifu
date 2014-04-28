/**
 * Copyright [2012-2014] eBay Software Foundation
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
package ml.shifu.shifu.container.obj;

import java.util.HashMap;
import java.util.Map;

import ml.shifu.shifu.util.Constants;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * ModelMetaConf class
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelBasicConf {

    @JsonDeserialize(using = RunModeDeserializer.class)
    public static enum RunMode {
        local, mapred
    }
    
	private String name;
	
	private String author;
	
	private String description;
	
	private String version = Constants.version;
	
	private RunMode runMode = RunMode.local;
	
	private Map<String, String> customPaths;

    public ModelBasicConf() {
        customPaths = new HashMap<String, String>(1);
        /** 
         * Since most user won't use this function,
         * hidden the custom paths for creating new model.
         */
        // customPaths.put(Constants.KEY_HDFS_MODEL_SET_PATH, null);
    }
	   
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public RunMode getRunMode() {
        return runMode;
    }

    public void setRunMode(RunMode runMode) {
        this.runMode = runMode;
    }

    public Map<String, String> getCustomPaths() {
        return customPaths;
    }

    public void setCustomPaths(Map<String, String> customPaths) {
        this.customPaths = customPaths;
    }

    @Override
	public boolean equals(Object obj) {
		if ( obj == null || !(obj instanceof ModelBasicConf) ) {
			return false;
		}
		
		if ( obj == this ) {
			return true;
		}
		
		ModelBasicConf basic = (ModelBasicConf) obj;
		return StringUtils.equals(basic.getName(), name) 
				&& StringUtils.equals(basic.getAuthor(), author)
				&& StringUtils.equals(basic.getDescription(), description); 
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
}
