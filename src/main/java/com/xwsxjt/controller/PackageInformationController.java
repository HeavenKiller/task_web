package com.xwsxjt.controller; /**
 * @Project: task-web
 * @Package com.xwsxjt.controller
 * @author xiaoshijie
 * @date 2017/10/25 10:17
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.base.domain.Page;
import com.xwsxjt.domain.PackInfoImage;
import com.xwsxjt.domain.PackageInformation;
import com.xwsxjt.service.FileInfoService;
import com.xwsxjt.service.PackInfoImageService;
import com.xwsxjt.service.PackageInformationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xwsxjt.vo.PackInfoVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @ClassName PackageInformationController
 * @Description 套餐信息Controller类
 * @date 2017/10/25
 */
@Controller
@RequestMapping(value = "packinfo")
public class PackageInformationController {
    @Resource
    private PackageInformationService packageInformationService;
    @Resource
    private FileInfoService fileInfoService;
    @Resource
    private PackInfoImageService packInfoImageService;

    private final static Logger logger = LogManager.getLogger(PackageInformationController.class.getName());

    @RequestMapping(value = "getPackageInformationList.do")
    @ResponseBody
    public Map getPackageInformationList(@RequestBody Page page){
        //检查pageSize和pageNow是否为空
        Page.checkOrInitPage(page);
        //为pageNowCounts设值
        page.setPageNowCounts(Page.getPageNowCountsByPageNowAndPageSize(page.getPageNow(),page.getPageSize()));
        //获得rowCount
        page.setRowCount(packageInformationService.getRowCount());
        //获得pageCount
        page.setPageCount(Page.getPageCountByRowCountAndPageSize(page.getRowCount(),page.getPageSize()));
        Map<String,Object> map = new HashMap<>();
        List<PackageInformation> packageInformationList = packageInformationService.getPackageInformationList(page);
        if (packageInformationList != null && packageInformationList.size() > 0){
            Map<String, List<PackInfoImage>> packInfoImageMap = new HashMap<>();
            for (PackageInformation packageInformation:packageInformationList){
                List<PackInfoImage> packInfoImageList = packInfoImageService.findPackInfoImageListByPackInfoId(packageInformation.getId());
                packInfoImageMap.put(""+packageInformation.getId(), packInfoImageList);
            }
            map.put("packInfoImageMap", packInfoImageMap);
        }
        map.put("page", page);
        map.put("packageInformationList", packageInformationList);
        map.get("packInfoImageMap");
        return map;
    }

    @RequestMapping(value = "getPackInfo.do")
    @ResponseBody
    public PackageInformation getPackInfo(@RequestBody PackInfoVo packInfoVo){
        Map<String, Object> packInfoMap = new HashMap<>();
        packInfoMap.put("id", packInfoVo.getPackInfoId());
        PackageInformation packageInformation = packageInformationService.getPackInfoAllInfo(packInfoMap);
        return packageInformation;
    }

    @RequestMapping(value = "addPackInfo.do")
    @ResponseBody
    public Map addPackInfo(@RequestBody PackInfoVo packInfoVo, HttpServletRequest request){
        Map<String,Object> resultMap = new HashMap<>();

        packInfoVo.getPackInfoImage().getName();
        return resultMap;
    }
}

