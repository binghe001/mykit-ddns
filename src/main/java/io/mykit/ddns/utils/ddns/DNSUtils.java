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
package io.mykit.ddns.utils.ddns;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.alidns.model.v20150109.DescribeDomainRecordsRequest;
import com.aliyuncs.alidns.model.v20150109.DescribeDomainRecordsResponse;
import com.aliyuncs.alidns.model.v20150109.UpdateDomainRecordRequest;
import com.aliyuncs.alidns.model.v20150109.UpdateDomainRecordResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import io.mykit.ddns.utils.common.ObjectUtils;
import io.mykit.ddns.utils.constants.Constants;
import io.mykit.ddns.utils.ip.IPUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author binghe
 * @version 1.0.0
 * @description DNS工具类
 */
public class DNSUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DNSUtils.class);

    /**
     * 修改解析记录
     */
    private static UpdateDomainRecordResponse updateDomainRecord(UpdateDomainRecordRequest request, IAcsClient client){
        try {
            // 调用SDK发送请求
            return client.getAcsResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
            // 发生调用错误，抛出运行时异常
            throw new RuntimeException();
        }
    }


    /**
     * 获取主域名的所有解析记录列表
     */
    private static DescribeDomainRecordsResponse describeDomainRecords(DescribeDomainRecordsRequest request, IAcsClient client){
        try {
            // 调用SDK发送请求
            return client.getAcsResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
            // 发生调用错误，抛出运行时异常
            throw new RuntimeException();
        }
    }

    /**
     * 更新域名绑定的动态IP
     * @param domainName 域名（顶级域名）
     * @param rrs 耳机域名的前缀，例如，二级域名为test.binghe.com,则此参数保存为[test]
     */
    public static void updateDomainIP(String domainName, String ... rrs){
        List<String> rrList = null;
        if (! ObjectUtils.isEmpty(rrs)){
            rrList = Arrays.asList(rrs);
        }
        // 设置鉴权参数，初始化客户端
        DefaultProfile profile = DefaultProfile.getProfile(Constants.REGION_ID, Constants.ACCESS_KEY_ID, Constants.ACCESS_KEY_SECRET);

        IAcsClient client = new DefaultAcsClient(profile);

        // 查询指定二级域名的最新解析记录
        DescribeDomainRecordsRequest describeDomainRecordsRequest = new DescribeDomainRecordsRequest();
        // 主域名
        describeDomainRecordsRequest.setDomainName(domainName);
        // 解析记录类型
        describeDomainRecordsRequest.setType(Constants.TYPE);
        describeDomainRecordsRequest.setPageSize(Constants.PAGE_SIZE);
        DescribeDomainRecordsResponse describeDomainRecordsResponse = describeDomainRecords(describeDomainRecordsRequest, client);

        LOGGER.debug(Constants.DESCRIBE_ACTION, describeDomainRecordsResponse);

        List<DescribeDomainRecordsResponse.Record> domainRecords = describeDomainRecordsResponse.getDomainRecords();
        // 最新的一条解析记录
        if(!ObjectUtils.isEmpty(domainRecords)){
            // 获取当前主机公网IP
            String currentHostIP = IPUtils.getCurrentHostIP();
            LOGGER.debug("-------------------------------当前主机公网IP为："+currentHostIP+"-------------------------------");
            for (DescribeDomainRecordsResponse.Record record : domainRecords){
                //如果传入的二级域名前缀不为空，同时传入的二级域名前缀中不包含当前记录的RR值，则跳过本次循环
                if (!ObjectUtils.isEmpty(rrList) && !rrList.contains(record.getRR())){
                    continue;
                }
                // 记录ID
                String recordId = record.getRecordId();
                // 记录值
                String recordsValue = record.getValue();
                //当前主机公网IP与阿里云上映射的IP不相等，则更新IP
                if(!currentHostIP.equals(recordsValue)){
                    // 修改解析记录
                    UpdateDomainRecordRequest updateDomainRecordRequest = new UpdateDomainRecordRequest();
                    // 主机记录
                    updateDomainRecordRequest.setRR(record.getRR());
                    // 记录ID
                    updateDomainRecordRequest.setRecordId(recordId);
                    // 将主机记录值改为当前主机IP
                    updateDomainRecordRequest.setValue(currentHostIP);
                    // 解析记录类型
                    updateDomainRecordRequest.setType(Constants.TYPE);
                    UpdateDomainRecordResponse updateDomainRecordResponse = updateDomainRecord(updateDomainRecordRequest, client);
                    LOGGER.info("updateDomainRecord: {}",updateDomainRecordResponse);
                }
            }
        }
    }
}
