package com.lisao.lisaolibrary.http.convert;

/**
 * Created by yuweichen on 15/11/30.
 */
import com.alibaba.fastjson.JSON;
import com.lisao.lisaolibrary.logger.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import okhttp3.ResponseBody;
import retrofit2.Converter;


public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody,T> {

    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private Type type;
    public FastJsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {

        InputStreamReader isr = null;
        BufferedReader bf = null;
        try {
            isr = new InputStreamReader(value.byteStream(), UTF_8);
            bf = new BufferedReader(isr);
            StringBuilder buffer = new StringBuilder();
            String line ;
            while ((line = bf.readLine()) != null) {
                buffer.append(line);
            }
           // Logger.json(buffer.toString());
            return JSON.parseObject(buffer.toString(), type);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.e(e.getMessage());
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException ignored) {
                }
            }
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException ignored) {
                }
            }
        }
        return null;
    }
}