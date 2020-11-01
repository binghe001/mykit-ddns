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
package io.mykit.ddns.task;

import io.mykit.ddns.bean.DomainInfo;
import io.mykit.ddns.utils.common.ObjectUtils;
import io.mykit.ddns.utils.ddns.DNSUtils;

import java.util.List;

/**
 * @author binghe
 * @version 1.0.0
 * @description 批量执行任务
 */
public class BatchScheduleTask implements Runnable {

    private List<DomainInfo> domainInfoList;

    public BatchScheduleTask(List<DomainInfo> domainInfoList) {
        this.domainInfoList = domainInfoList;
    }

    @Override
    public void run() {
        if (!ObjectUtils.isEmpty(domainInfoList)){
            domainInfoList.stream().forEach((di) -> {
                new Thread(() -> {
                    DNSUtils.updateDomainIP(di.getTopDomain(), di.getChildDomainPrefix());
                }).start();
            });
        }
    }
}
