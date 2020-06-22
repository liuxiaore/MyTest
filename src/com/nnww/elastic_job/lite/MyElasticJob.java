package com.nnww.elastic_job.lite;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

public class MyElasticJob implements SimpleJob {
    
    @Override
    public void execute(ShardingContext context) {
        switch (context.getShardingItem()) {
            case 0:
                System.out.println("我是1");
                break;
            case 1: 
                // do something by sharding item 1
                System.out.println("我是2");
                break;
            case 2: 
                // do something by sharding item 2
                System.out.println("我是3");
                break;
            // case n: ...
        }
    }
}