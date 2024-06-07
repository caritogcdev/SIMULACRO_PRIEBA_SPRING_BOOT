package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.MessageReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.MessageResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Message;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.CourseRepository;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.UserRepository;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.ServiceHelper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.ICourseMapper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.IMessageMapper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.IUserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageMapper implements IMessageMapper {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    private final ServiceHelper serviceHelper;

    @Autowired
    private final IUserMapper userMapper;

    @Autowired
    private final ICourseMapper courseMapper;

    @Override
    public Message requestToEntity(MessageReq request) {
        return Message.builder()
                .userSender(this.serviceHelper.find(request.getUserSender(), userRepository, "userSender"))
                .userReceiver(this.serviceHelper.find(request.getUserReceiver(), userRepository, "userReceiver"))
                .courseId(this.serviceHelper.find(request.getCourseId(), courseRepository, "course"))
                .message_content(request.getMessage_content())
                .build();
    }

    @Override
    public MessageResp entityToResponse(Message entity) {
        return MessageResp.builder()
                .id(entity.getId())
                .userSender(this.userMapper.entityToResponse(entity.getUserSender()))
                .userReceiver(this.userMapper.entityToResponse(entity.getUserReceiver()))
                .courseId(this.courseMapper.entityToResponse(entity.getCourseId()))
                .message_content(entity.getMessage_content())
                .sent_date(entity.getSent_date())
                .build();
    }
}
