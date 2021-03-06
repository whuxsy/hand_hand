package whu.yes.hand_hand.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whu.yes.hand_hand.entity.Mission;
import whu.yes.hand_hand.service.MissionService;

import java.util.List;

@RestController
@RequestMapping("/mission")
@Api(value = "MissionController",tags = "任务控制类")
public class MissionController {
    @Autowired
    private MissionService missionService;

    @GetMapping
    @ApiOperation(
            value = "获取所有任务",
            notes = "获取所有任务的信息"
    )
    public List<Mission> getAllMission(){
        return missionService.getAllMission();
    }

    @GetMapping(value = "/mid") //路径和获取所有书不同
    @ApiOperation(
            value = "按id获取单个任务",
            notes = "根据id获取单个任务信息，id为整数，查到则返回实体，查不到返回null"
    )
    @ApiImplicitParam(value = "任务编号", name = "mid",paramType = "query",dataType = "int")
    public Mission getById(@RequestParam("mid") int mid){
        return missionService.getMissionById(mid);
    }

    @PostMapping(value = "/")
    @ApiOperation(
            value = "新增一个任务",
            notes = "填写任务信息后，增加一个任务"
    )
    public void insertMission(@RequestBody Mission mission){
        missionService.insertMission(mission);
    }

    @PutMapping(value = "/")
    @ApiOperation(
            value = "更新任务",
            notes = "修改任务信息"
    )
    public void updateMission(@RequestBody Mission mission){
        missionService.updateMission(mission);
    }


    @DeleteMapping(value = "/mid")
    @ApiOperation(
            value = "按mid删除一个任务",
            notes = "根据id删除单个任务"
    )
    @ApiImplicitParam(value = "任务编号", name = "mid",paramType = "query")
    public void deleteById(@RequestParam("mid") int mid){
         missionService.deleteMission(mid);
    }


}
