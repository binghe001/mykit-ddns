/**
 * Copyright 2020-9999 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mykit.ddns.utils.constants;

/**
 * @author binghe
 * @version 1.0.0
 * @description 常量类
 */
public class Constants {

    /**
     * 阿里云ACCESS_KEY_ID
     */
    public static final String ACCESS_KEY_ID = "XXXXXXXXX";
    /**
     * 阿里云ACCESS_KEY_SECRET
     */
    public static final String ACCESS_KEY_SECRET = "XXXXXXXXXXXXXX";

    /**
     * alidns
     */
    public static final String DNS_DOMAIN = "alidns.aliyuncs.com";

    /**
     * 地域ID
     */
    public static final String REGION_ID = "cn-hangzhou";

    /**
     * 这里使用jsonip.com第三方接口获取本地IP
     */
    public static final String JSON_IP_URL = "https://jsonip.com/";

    /**
     * GET请求
     */
    public static final String HTTP_GET = "GET";

    /**
     * 版本
     */
    public static final String VERSION = "2015-01-09";

    /**
     * describe action
     */
    public static final String DESCRIBE_ACTION = "DescribeDomainRecords";

    /**
     * 域名key
     */
    public static final String DOMAIN_NAME_KEY = "DomainName";
    /**
     * 域名记录
     */
    public static final String DOMAIN_RECORDS = "DomainRecords";

    /**
     * 记录的key
     */
    public static final String RECORD_KEY = "Record";

    /**
     * 阿里云IP的索引下标
     */
    public static final int ALIYUN_IP_INDEX = 0;

    /**
     * 阿里云IP的key
     */
    public static final String ALIYUN_IP_KEY = "Value";

    /**
     * 类型
     */
    public static final String TYPE = "A";

    /**
     * 每页的记录数
     */
    public static final Long PAGE_SIZE = 100L;

    /**
     * 查分二级域名的分隔符
     */
    public static final String SPLIT_REGEX = ",";
}
