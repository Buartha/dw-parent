#!/bin/bash
export PATH=$PATH:/bigf/admin/flink/flink/bin/
flink run -c com.spdb.streaming.transaction.FlinkSaveTransaction lib/streaming-transaction-1.1.jar --confPath conf/FBXTransaction.yaml
