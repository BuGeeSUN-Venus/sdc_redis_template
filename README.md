# 方法介绍

## SetOperations
```
    /**
     * 给集合key添加多个值，集合不存在创建后再添加
     *
     * @param key 不能为null
     * @param values
     * @return
     */
    Long add(K key, V... values);

    /**
     * 移除集合中多个value值
     * @param key 不能为null
     * @param values
     * @return
     */
    Long remove(K key, Object... values);

    /**
     * 随机删除集合中的一个值，并返回。
     *
     * @param key 不能为null
     * @return
     */
    V pop(K key);

    /**
     * 把源集合中的一个元素移动到目标集合。成功返回true.
     *
     * @param key 不能为null
     * @param value
     * @param destKey must not be {@literal null}.
     * @return
     */
    Boolean move(K key, V value, K destKey);

    /**
     * 返回结合的大小
     *
     * @param key 不能为null
     * @return
     * @see <a href="http://redis.io/commands/scard">Redis Documentation: SCARD</a>
     */
    Long size(K key);

    /**
     * 检查集合中是否包含某个元素
     *
     * @param key 不能为null
     * @param o
     * @return
     */
    Boolean isMember(K key, Object o);

    /**
     * 求指定集合与另一个集合的交集
     *
     * @param key 不能为null
     * @param otherKey must not be {@literal null}.
     * @return
     */
    Set<V> intersect(K key, K otherKey);

    /**
     *求指定集合与另外多个个集合交集
     *
     * @param key 不能为null
     * @param otherKeys 不能为null
     * @return
     * @see <a href="http://redis.io/commands/sinter">Redis Documentation: SINTER</a>
     */
    Set<V> intersect(K key, Collection<K> otherKeys);

    /**
     * 求指定集合与另一个集合的交集，并且存储到目标集合中
     *
     * @param key 不能为null
     * @param otherKey 不能为null
     * @param destKey 不能为null
     * @return 返回目标集合的长度
     */
    Long intersectAndStore(K key, K otherKey, K destKey);

    /**
     * 求指定集合与另外多个集合中的交集保存到目标集合
     *
     * @param key 不能为null
     * @param otherKeys 不能为null
     * @param destKey 不能为null
     * @return
     */
    Long intersectAndStore(K key, Collection<K> otherKeys, K destKey);

    /**
     * 求指定集合与另一个集合的并集 并返回并集
     *
     * @param key 不能为null
     * @param otherKey 不能为null
     * @return
     * @see <a href="http://redis.io/commands/sunion">Redis Documentation: SUNION</a>
     */
    Set<V> union(K key, K otherKey);

    /**
     * 求指定集合与另外多个集合的并集 并返回并集
     *
     * @param key 不能为null
     * @param otherKeys 不能为null
     * @return
     * @see <a href="http://redis.io/commands/sunion">Redis Documentation: SUNION</a>
     */
    Set<V> union(K key, Collection<K> otherKeys);

    /**
     *求指定集合与另一个集合的并集，并保存到目标集合
     */
    Long unionAndStore(K key, K otherKey, K destKey);

    /**
     *求指定集合与另外多个集合的并集，并保存到目标集合
     */
    Long unionAndStore(K key, Collection<K> otherKeys, K destKey);

    /**
     * 求指定集合与另一个集合的差集
     */
    Set<V> difference(K key, K otherKey);

    /**
     * 求指定集合与另外多个集合的差集
     */
    Set<V> difference(K key, Collection<K> otherKeys);

    /**
     * 求指定集合与另一个集合的差集，并保存到目标集合
     */
    Long differenceAndStore(K key, K otherKey, K destKey);

    /**
     * 求指定集合与另外多个集合的差集，并保存到目标集合
     */
    Long differenceAndStore(K key, Collection<K> otherKeys, K destKey);

    /**
     * 获取集合中的所有元素
     */
    Set<V> members(K key);

    /**
     * 随机获取集合中的一个元素
     */
    V randomMember(K key);

    /**
     *随机返回集合中指定数量的元素。随机的元素不会重复
     */
    Set<V> distinctRandomMembers(K key, long count);

    /**
     * 随机返回集合中指定数量的元素。随机的元素可能重复
     */
    List<V> randomMembers(K key, long count);

    /**
     * 获取集合的游标。通过游标可以遍历整个集合。
     * ScanOptions 这个类中使用了构造者 工厂方法 单例。 通过它可以配置返回的元素
     * 个数 count  与正则匹配元素 match. 不过count设置后不代表一定返回的就是count个。这个只是参考
     * 意义
     *
     * @param key
     * @param options 
     * @return
     * @since 1.4
     */
    Cursor<V> scan(K key, ScanOptions options);
```
## ValueOperations
```
    /**
    *设置 key 的值为 value
    *如果key不存在添加key 保存值为value
    *如果key存在则对value进行覆盖
    */
    void set(K key, V value);

    /**
     * 设置 key 的值为 value
     * 其它规则与 set(K key, V value)一样
     * @param key 不能为空
     * @param value 设置的值
     * @param timeout 设置过期的时间
     * @param unit 时间单位。不能为空
     * @see <a href="http://redis.io/commands/setex">Redis Documentation: SETEX</a>
     */
    void set(K key, V value, long timeout, TimeUnit unit);

    /**
     *如果key不存在，则设置key 的值为 value. 存在则不设置
     *设置成功返回true 失败返回false
     * @param key key不能为空
     * @param value 设置的值
     */
    Boolean setIfAbsent(K key, V value);

    /**
     * 把一个map的键值对添加到redis中，key-value 对应着 key value。如果key已经存在就覆盖，
     * @param map不能为null 为null抛出空指针异常 可以为空集合
     */
    void multiSet(Map<? extends K, ? extends V> map);

    /**
     * 把一个map的键值对添加到redis中，key-value 对应着 key value。 当且仅当map中的所有key都
     * 不存在的时候，添加成功返回 true，否则返回false.
     * @param map map不能为空 可以为empty
     */
    Boolean multiSetIfAbsent(Map<? extends K, ? extends V> map);

    /**
     * 根据 key 获取对应的value 如果key不存在则返回null
     * @param key 不能为null
     */
    V get(Object key);

    /**
     * 设置key的值为value 并返回旧值。 如果key不存在返回为null
     * @param key 不能为null
     */
    V getAndSet(K key, V value);

    /**
     * 根据提供的key集合按顺序获取对应的value值
     * @param 集合不能为null 可以为empty 集合
     */
    List<V> multiGet(Collection<K> keys);

    /**
     * 为key 的值加上 long delta. 原来的值必须是能转换成Integer类型的。否则会抛出异常。
     * @param key 不能为null
     * @param delta 需要增加的值
     */
    Long increment(K key, long delta);

    /**
     * 为key 的值加上 double delta. 原来的值必须是能转换成Integer类型的。否则会抛出异常。
     * 添加double后不能再加整数。已经无法在转换为Integer
     * @param key 不能为null
     * @param 增加的值
     */
    Double increment(K key, double delta);

    /**
     * 为 key的值末尾追加 value 如果key不存在就直接等于 set(K key, V value)
     *
     * @param key 不能为null
     * @param value 追加的值
     * @see <a href="http://redis.io/commands/append">Redis Documentation: APPEND</a>
     */
    Integer append(K key, String value);

    /**
     * 获取key 值从 start位置开始到end位置结束。 等于String 的 subString 前后闭区间
     *0 -1 整个key的值
     *-4 -1 从尾部开始往前截长度为4
     * @param key 不能为null
     * @param start 起始位置
     * @param end   结束位置
     * @see <a href="http://redis.io/commands/getrange">Redis Documentation: GETRANGE</a>
     */
    String get(K key, long start, long end);

    /**
     * 将value从指定的位置开始覆盖原有的值。如果指定的开始位置大于字符串长度，先补空格在追加。
     * 如果key不存在，则等于新增。长度大于0则先补空格 set("key10", "abc", 3) 得到结果为：
     * 3空格 +"abc"
     * @param key 不能为null
     * @param value 值
     * @param offset 开始的位置
     */
    void set(K key, V value, long offset);

    /**
     * 获取key的value的长度。key不存在返回0
     * @param key 不能为空
     */
    Long size(K key);

    /**
     * 设置key的值偏移量为offset的bit位上的值为0或者1.true:1 false:0
     *
     * @param key 不能为空
     * @param offset 偏移量
     * @param value true or false
     */
    Boolean setBit(K key, long offset, boolean value);

    /**
     * 获取key的值偏移量offset的bit位的值。 返回true or false
     *
     * @param key 不能为空
     * @param offset 偏移量
     * 可以通过redis的 JedisConverters 对布尔结果进行转换
     */
    Boolean getBit(K key, long offset);
```

## ListOperations
```

    /**
     * 获取指定key的范围内的value值的 list列表。 （0  -1）反回所有值列表 
     *
     * @param key 不能为null
     * @param start 起始位置
     * @param end  结束位置
     * @return V的列表
     */
    List<V> range(K key, long start, long end);

    /**
     * 保留key指定范围内的列表值。其它的都删除。
     *
     * @param key 不能为null
     * @param start 起始位置
     * @param end  结束位置
     */
    void trim(K key, long start, long end);

    /**
     * 获取key 列表的长度
     *
     * @param key 不能为null
     * @return 列表长度
     */
    Long size(K key);

    /**
     * 从key列表左边（从头部）插入 值
     *
     * @param key 不能为空
     * @param value 插入列表的值
     * @return 返回列表插入后的长度
     */
    Long leftPush(K key, V value);

    /**
     * 从key列表左边（头部）插入多个值
     *
      * @param key 不能为空
     * @param value 插入列表的值
     * @return 返回列表插入后的长度
     */
    Long leftPushAll(K key, V... values);

/**
     * 从key列表左边（头部）依次插入集合中的值
     *
     * @param key 不能为空
     * @param value 插入列表的值
     * @return 返回列表插入后的长度
     */
    Long leftPushAll(K key, Collection<V> values);

    /**
     * 如果列表存在，则在列表左边插入值value
     *
      * @param key 不能为空
     * @param value 插入列表的值
     * @return 返回列表插入后的长度
     */
    Long leftPushIfPresent(K key, V value);

    /**
     * 在key的列表中指定的value左边（前面）插入一个新的value.
     *  如果 指定的value不存在则不插入任何值。
     *
     * @param key 不能为空
     * @param pivot 指定的value
     * @param value 插入的value
     * @return 返回列表的c行都
     */
    Long leftPush(K key, V pivot, V value);

    /**
     * 参照 leftPush(K key, V value)
     */
    Long rightPush(K key, V value);

    /**
     *  参照 Long leftPushAll(K key, V... values);
     */
    Long rightPushAll(K key, V... values);

    /**
     * 参照 Long rightPushAll(K key, Collection<V> values);
     */
    Long rightPushAll(K key, Collection<V> values);

    /**
    *参照     Long rightPushIfPresent(K key, V value);
     */
    Long rightPushIfPresent(K key, V value);

    /**
     * 参照 Long rightPush(K key, V pivot, V value);
     *
     */
    Long rightPush(K key, V pivot, V value);

    /**
     * 设置key列表中指定位置的值为value index不能大于列表长度。大于抛出异常
     * 为负数则从右边开始计算
     * @param key 不能为空
     * @param index
     * @param value
     */
    void set(K key, long index, V value);

    /**
     * 删除列表中第一个遇到的value值。count指定删除多少个。
     *
     * @param key 不能为null
     * @param count
     * @param value
     * @return 返回列表的长度
     */
    Long remove(K key, long count, Object value);

    /**
     * 获取列表中指定索引的value
     *
     * @param key 不能为null
     * @param index
     * @return
     * @see <a href="http://redis.io/commands/lindex">Redis Documentation: LINDEX</a>
     */
    V index(K key, long index);

    /**
     * 移除列表中的第一个值，并返回该值
     *
     * @param key 不能为null
     * @return 移除的值
     */
    V leftPop(K key);

    /**
     * 阻塞版本的 leftPop(K key) 移除列表的第一个值，并且返回。如果列表为空，
     * 则一直阻塞指定的时间单位
     *
     * @param key 不能为null
     * @param timeout 时间
     * @param unit 不能为空，时间单位
     * @return
     * @see <a href="http://redis.io/commands/blpop">Redis Documentation: BLPOP</a>
     */
    V leftPop(K key, long timeout, TimeUnit unit);

    /**
     * 参照 V leftPop(K key);
     */
    V rightPop(K key);

    /**
     * 参照  V leftPop(K key, long timeout, TimeUnit unit);
     */
    V rightPop(K key, long timeout, TimeUnit unit);

    /**
     * 从指定列表中从右边（尾部）移除第一个值，并将这个值从左边（头部）插入目标列表
     * 返回移除（插入）的值
     */
    V rightPopAndLeftPush(K sourceKey, K destinationKey);

    /**
     * 阻塞版本的   V rightPopAndLeftPush(K sourceKey, K destinationKey);
     * 如果移除的列表中没有值，则一直阻塞指定的单位时间
     */
    V rightPopAndLeftPush(K sourceKey, K destinationKey, long timeout, TimeUnit unit);
```
## HashOperations
```
    /**
     * 从散列中删除给定的多个元素
     * @param key 不能为null 散列的名称
     * @param hashKeys 需要删除的keys集合
     */
    Long delete(H key, Object... hashKeys);

    /**
     * 判断散列中是否存在某个key
     */
    Boolean hasKey(H key, Object hashKey);

    /**
     * 得到某个三散列中key的hash值
     */
    HV get(H key, Object hashKey);

    /**
     * 得到多个key的值。
     */
    List<HV> multiGet(H key, Collection<HK> hashKeys);

    /**
     *为散了中某个值加上 整型 delta
     */
    Long increment(H key, HK hashKey, long delta);

    /**
     * 为散了中某个值加上 double delta
     */
    Double increment(H key, HK hashKey, double delta);

    /**
     * 获取散列中所有的key集合
     */
    Set<HK> keys(H key);

    /**
     * 获取散列的大小
     */
    Long size(H key);

    /**
     * 为散列添加多个key-value键值对
     *
     * @param key must not be {@literal null}.
     * @param m must not be {@literal null}.
     */
    void putAll(H key, Map<? extends HK, ? extends HV> m);

    /**
     * 为散列添加或者覆盖一个 key-value键值对
     */
    void put(H key, HK hashKey, HV value);

    /**
     * 为散列添加一个key-value键值对。如果存在则不添加不覆盖。返回false
     */
    Boolean putIfAbsent(H key, HK hashKey, HV value);

    /**
     * 获取散列的value集合
     */
    List<HV> values(H key);

    /**
     * 获取散列的key-value键值对集合
     */
    Map<HK, HV> entries(H key);

    /**
     * 获取散列的游标。
     * 可以参考：http://blog.csdn.net/pengdandezhi/article/details/78909041
     */
    Cursor<Map.Entry<HK, HV>> scan(H key, ScanOptions options);
```
## ZSetOperations
```
    /**
     * 给有序集合添加一个指定分数的成员 如果成员存在则覆盖
     *
     * @param key must not be {@literal null}.
     * @param score the score.
     * @param value the value.
     * @return
     */
    Boolean add(K key, V value, double score);

    /**
     * 通过TypedTuple的方式，往有序集合中添加成员集合。
     *TypedTuple 默认实现为 DefaultTypedTuple
     * @param key must not be {@literal null}.
     * @param tuples must not be {@literal null}.
     * @return
     */
    Long add(K key, Set<TypedTuple<V>> tuples);

    /**
     * 移除有序集合中指定的多个成员. 如果成员不存在则忽略
     *
     * @param key must not be {@literal null}.
     * @param values must not be {@literal null}.
     * @return
     */
    Long remove(K key, Object... values);

    /**
     * 给有序集合中的指定成员的分数增加 delta
     * @param key must not be {@literal null}.
     * @param delta
     * @param value the value.
     * @return
     */
    Double incrementScore(K key, V value, double delta);

    /**
     * 计算并返回成员在有序集合中从低到高的排名（第一名为0）
     *
     * @param key must not be {@literal null}.
     * @param o the value.
     * @return
     */
    Long rank(K key, Object o);

    /**
     * 计算并返回成员在有序集合中从高到低的排名（第一名为0）
     * @param key must not be {@literal null}.
     * @param o the value.
     * @return
     */
    Long reverseRank(K key, Object o);

    /**
     * 获取指定范围内的成员集合。（0 -1）返回所有。 如果为正数，则按正常顺序取，如果为负数则反序取。
     *
     * @param key must not be {@literal null}.
     * @param start
     * @param end
     * @return
     */
    Set<V> range(K key, long start, long end);

    /**
     * 获取有序集合中指定分数范围内的成员集合
     *
     * @param key must not be {@literal null}.
     * @param start
     * @param end
     * @return
     */
    Set<TypedTuple<V>> rangeWithScores(K key, long start, long end);

    /**
     * 获取有序集合中分数在指定的最小值 与最大值之间的所有成员集合  闭合区间
     *
     * @param key must not be {@literal null}.
     * @param min
     * @param max
     * @return
     */
    Set<V> rangeByScore(K key, double min, double max);

    /**
     * 获取有序集合中分数在指定的最小值 与最大值之间的所有成员的TypedTuple集合  闭合区间
     * @param key must not be {@literal null}.
     * @param min
     * @param max
     * @return
     */
    Set<TypedTuple<V>> rangeByScoreWithScores(K key, double min, double max);

    /**
     *从有序集合中从指定位置（offset)开始，取 count个范围在（min)与（max)之间的成员集合
     * @param key must not be {@literal null}.
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    Set<V> rangeByScore(K key, double min, double max, long offset, long count);

    /**
     * 从有序集合中从指定位置（offset)开始，取 count个范围在（min)与（max)之间的
     * 成员TypedTuple集合
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    Set<TypedTuple<V>> rangeByScoreWithScores(K key, double min, double max, long offset, long count);

    /**
     * 从有序集合中获取指定范围内从高到低的成员集合
     *
     * @param key must not be {@literal null}.
     * @param start
     * @param end
     * @return
     */
    Set<V> reverseRange(K key, long start, long end);

    /**
     *从有序集合中获取指定范围内从高到低的成员TypedTuple集合
     *
     * @param key must not be {@literal null}.
     * @param start
     * @param end
     * @return
     */
    Set<TypedTuple<V>> reverseRangeWithScores(K key, long start, long end);

    /**
     *从有序集合中获取分数在指定范围内从高到低的成员集合
     *
     * @param key must not be {@literal null}.
     * @param min
     * @param max
     * @return
     */
    Set<V> reverseRangeByScore(K key, double min, double max);

    /**
     *从有序集合中获取分数在指定范围内从高到低的成员TypedTuple集合
     */
    Set<TypedTuple<V>> reverseRangeByScoreWithScores(K key, double min, double max);

    /**
     * 从有序集合中从指定位置（offset)开始 获取 count个
     * 分数在指定（min, max)范围内从高到低的成员集合
     * sorted set ordered high -> low.
     *
     * @param key must not be {@literal null}.
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    Set<V> reverseRangeByScore(K key, double min, double max, long offset, long count);

    /**
     *  从有序集合中从指定位置（offset)开始 获取 count个
     * 分数在指定（min, max)范围内从高到低的成员TypedTuple集合
     */
    Set<TypedTuple<V>> reverseRangeByScoreWithScores(K key, double min, double max, long offset, long count);

    /**
     * 统计分数在范围内的成员个数
     */
    Long count(K key, double min, double max);

    /**
     * 返回有序集合的大小
     */
    Long size(K key);

    /**
     * 返回有序集合的大小
     */
    Long zCard(K key);

    /**
     *获取有序集合中某个成员的分数
     */
    Double score(K key, Object o);

    /**
     * 移除有序集合中从start开始到end结束的成员 闭区间
     */
    Long removeRange(K key, long start, long end);

    /**
     * 移除有序集合中分数在指定范围内[min,max]的成员
     */
    Long removeRangeByScore(K key, double min, double max);

    /**
     * 求两个有序集合的并集，并存到目标集合中。 如果存在相同的成员，则分数相加。
     */
    Long unionAndStore(K key, K otherKey, K destKey);

    /**
     * 
     *一个有序集合与多个有序集合进行并集， 如果存在相同成员，则分数相加。
     */
    Long unionAndStore(K key, Collection<K> otherKeys, K destKey);

    /**
     * 求两个有序集合中相同成员的并集（分数相加），并存到目标集合中。没有共同的成员则忽略
     */
    Long intersectAndStore(K key, K otherKey, K destKey);

    /**
     * 一个有序集合与多个有序集合进行相同成员并集， 如果存在不相同相同成员，则忽略
     */
    Long intersectAndStore(K key, Collection<K> otherKeys, K destKey);

    /**
     * 获取有序集合的TypedTuple游标。
     * ScanOptions  可以配置匹配正则 设置参考的count
     */
    Cursor<TypedTuple<V>> scan(K key, ScanOptions options);

    /**
     * 获取有序集合中成员在指定范围内的集合（成员范围，不是分值范围）
     */
    Set<V> rangeByLex(K key, Range range);

    /**
     * 获取指定索引开始，获取count个成员在指定范围内的集合（成员范围，不是分值范围）
     */
    Set<V> rangeByLex(K key, Range range, Limit limit);
```