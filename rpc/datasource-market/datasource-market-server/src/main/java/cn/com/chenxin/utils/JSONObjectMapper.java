package cn.com.chenxin.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

/**
 * 处理spring-mvc日期时间类自动转换
 * @author Administrator
 * @since 0.0.2-SNAPSHOT
 */
public class JSONObjectMapper extends ObjectMapper {
    
    public JSONObjectMapper(){  
        CustomSerializerFactory factory = new CustomSerializerFactory();  
        factory.addGenericMapping(Date.class, new JsonSerializer<Date>(){  
            @Override  
            public void serialize(Date value,   
                    JsonGenerator jsonGenerator,   
                    SerializerProvider provider)  
                    throws IOException, JsonProcessingException {  
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
                jsonGenerator.writeString(sdf.format(value));  
            }  
        });  
        this.setSerializerFactory(factory);  
    }  

}
