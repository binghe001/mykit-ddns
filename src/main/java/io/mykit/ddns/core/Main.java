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
package io.mykit.ddns.core;

import io.mykit.ddns.pool.ScheduledThreadPool;
import io.mykit.ddns.task.ScheduledTask;

import java.util.concurrent.TimeUnit;

/**
 * @author binghe
 * @version 1.0.0
 * @description 项目启动类
 */
public class Main {

    public static void main(String[] args){
        //注册钩子函数
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                ScheduledThreadPool.shutdown();
            }
        }));
        //调用定时任务
        ScheduledTask task = new ScheduledTask("xxx.com", new String[]{"test"});
        ScheduledThreadPool.schedule(task, 0, 15, TimeUnit.MINUTES);
    }
}
