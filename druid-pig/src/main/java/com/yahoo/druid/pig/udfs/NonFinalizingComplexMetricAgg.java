/**
* Copyright 2015 Yahoo! Inc. Licensed under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance with the License.
* You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software distributed
* under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
* CONDITIONS OF ANY KIND, either express or implied. See the License for the
* specific language governing permissions and limitations under the License.
* See accompanying LICENSE file.
*/
package com.yahoo.druid.pig.udfs;

import java.nio.ByteBuffer;

import io.druid.query.aggregation.BufferAggregator;

import org.apache.pig.data.DataByteArray;

public class NonFinalizingComplexMetricAgg extends ComplexMetricAgg<DataByteArray>
{
  public NonFinalizingComplexMetricAgg(String aggFactorySpec, String metricType)
  {
    super(aggFactorySpec, metricType);
  }
  
  @Override
  protected DataByteArray exec(BufferAggregator agg, ByteBuffer buff)
  {
    return new DataByteArray(strategy.toBytes(agg.get(buff,0)));
  }
}
