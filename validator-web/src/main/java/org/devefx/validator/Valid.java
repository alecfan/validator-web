/*
 * Copyright 2016-2017, Youqian Yue (devefx@163.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.devefx.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.devefx.validator.groups.Default;
import org.devefx.validator.util.MultiValueMap;

@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Valid {
    
    /**
     * used the validation to validate
     */
    Class<? extends Validation> value();
    
    /**
     * the type of the request data type.
     */
    Class<?> requestType() default MultiValueMap.class;
    
    /**
     * the group or list of groups targeted for validation (defaults to {@link Default})
     */
    Class<?>[] groups() default { };
    
    
    Group[] groupsFormRequest() default { };
    
    public @interface Group {
        
        String name();
        
        boolean required() default true;
        
        GroupMapping[] mappings();
        
        Class<?> defaultGroup() default Default.class;
        
        public @interface GroupMapping {
            
            String name();
            
            Class<?> group();
        }
    }
    
}
