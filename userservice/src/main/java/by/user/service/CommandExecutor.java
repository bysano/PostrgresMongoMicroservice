package by.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by alka0317 on 8/2/2017.
 */
@Component
public class CommandExecutor {
    private static final Logger log = LoggerFactory.getLogger(CommandExecutor.class);
    public void execute(){
        List<Commands> commands = Arrays.asList(Commands.COMMAND1,Commands.COMMAND2,Commands.COMMAND3);
        Map<String,String> map = commands.stream().collect(Collectors.toMap(Commands::name,Commands::sendCommandtoUrl));
        log.info("Map {}",map);
    }


}

