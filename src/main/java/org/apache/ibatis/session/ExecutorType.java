/*
 *    Copyright 2009-2023 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.session;

/**
 * @author Clinton Begin
 */
public enum ExecutorType {

  // SimpleExecutor意味者每次都会关闭statement，下一次使用需要重新开启statement
  SIMPLE,

  // ReuseExecutor不会关闭statement，而是把statement放到缓存中。缓存的key为sql语句，value即为对应的statement。
  // 也就是说不会每一次调用都去创建一个 Statement 对象，而是会重复利用以前创建好的（如果SQL相同的话），这也就是在很多数据连接池库中常见的 PSCache 概念 。
  REUSE,
  // 在BatchExecutor中的doupdate并不会想前面两者那样执行返回行数，
  // 而是每次执行将statement预存到有序集合，官方说明这个executor是用于执行存储过程的和批量操作的，
  // 因此这个方法是循环或者多次执行构建一个存储过程或批处理过程。
  BATCH

}
