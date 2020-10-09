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

import io.mykit.ddns.utils.ddns.DNSUtils;

/**
 * @author binghe
 * @version 1.0.0
 * @description 调度任务
 */
public class ScheduledTask implements Runnable {

    private String domainName;

    private String[] rrs;

    public ScheduledTask(String domainName, String[] rrs) {
        this.domainName = domainName;
        this.rrs = rrs;
    }

    @Override
    public void run() {
        DNSUtils.updateDomainIP(domainName, rrs);
    }
}
