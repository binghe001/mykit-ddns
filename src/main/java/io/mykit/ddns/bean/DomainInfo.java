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
package io.mykit.ddns.bean;

import java.io.Serializable;

/**
 * @author binghe
 * @version 1.0.0
 * @description 域名的信息
 */
public class DomainInfo implements Serializable {

    /**
     * 顶级域名
     */
    private String topDomain;

    /**
     * 二级域名前缀数组
     */
    private String[] childDomainPrefix;

    public DomainInfo() {
    }

    public DomainInfo(String topDomain, String[] childDomainPrefix) {
        this.topDomain = topDomain;
        this.childDomainPrefix = childDomainPrefix;
    }

    public String getTopDomain() {
        return topDomain;
    }

    public void setTopDomain(String topDomain) {
        this.topDomain = topDomain;
    }

    public String[] getChildDomainPrefix() {
        return childDomainPrefix;
    }

    public void setChildDomainPrefix(String[] childDomainPrefix) {
        this.childDomainPrefix = childDomainPrefix;
    }
}
