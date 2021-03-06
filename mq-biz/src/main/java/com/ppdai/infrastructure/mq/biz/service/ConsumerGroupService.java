package com.ppdai.infrastructure.mq.biz.service;

import java.util.List;
import java.util.Map;

import com.ppdai.infrastructure.mq.biz.dto.request.ConsumerGroupCreateRequest;
import com.ppdai.infrastructure.mq.biz.dto.response.BaseUiResponse;
import com.ppdai.infrastructure.mq.biz.dto.response.ConsumerGroupCreateResponse;
import com.ppdai.infrastructure.mq.biz.dto.response.ConsumerGroupDeleteResponse;
import com.ppdai.infrastructure.mq.biz.dto.response.ConsumerGroupEditResponse;
import com.ppdai.infrastructure.mq.biz.entity.ConsumerGroupEntity;
import com.ppdai.infrastructure.mq.biz.entity.ConsumerGroupTopicEntity;
import com.ppdai.infrastructure.mq.biz.entity.QueueOffsetEntity;
import com.ppdai.infrastructure.mq.biz.service.common.BaseService;

/**
 * @author dal-generator
 */

public interface ConsumerGroupService extends BaseService<ConsumerGroupEntity> {
	List<ConsumerGroupEntity> getLastMetaConsumerGroup(long minMessageId, long maxMessageId);
	List<ConsumerGroupEntity> getLastRbConsumerGroup(long minMessageId, long maxMessageId);
	Map<String,ConsumerGroupEntity> getByNames(List<String> names);
	List<ConsumerGroupTopicEntity> getGroupTopic();
	List<ConsumerGroupEntity> getByOwnerNames(Map<String, Object> parameterMap);
	long countByOwnerNames(Map<String, Object> parameterMap);
	void rb(List<QueueOffsetEntity> queueOffsetEntities);
	void notifyRb(long consumerGroupId);
	void notifyRb(List<Long> consumerGroupIds);
	void notifyRbByNames(List<String> consumerGroupNames);
	void notifyMeta(long consumerGroupId);
	void notifyMeta(List<Long> consumerGroupIds);
	void notifyOffset(long consumerGroupId);
	void updateCache();
	Map<String,ConsumerGroupEntity> getCache();
	Map<Long,ConsumerGroupEntity> getIdCache();
	ConsumerGroupTopicEntity getTopic(String consumerGroupName,String topicName);
	ConsumerGroupCreateResponse createConsumerGroup(ConsumerGroupCreateRequest consumerGroupCreateRequest);
	ConsumerGroupEditResponse editConsumerGroup(ConsumerGroupEntity consumerGroupEntity);
	ConsumerGroupDeleteResponse deleteConsumerGroup(long consumerGroupId, boolean checkOnline);
	BaseUiResponse deleteTopicNameFromConsumerGroup(ConsumerGroupTopicEntity consumerGroupTopicEntity);
	BaseUiResponse addTopicNameToConsumerGroup(ConsumerGroupTopicEntity consumerGroupTopicEntity);
}
