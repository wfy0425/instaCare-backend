package inc.bugfree.instacare.controller;

import inc.bugfree.instacare.bean.AddressBean;
import inc.bugfree.instacare.bean.ResponseBean;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.service.AddressService;
import inc.bugfree.instacare.service.CommentsService;
import inc.bugfree.instacare.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//import inc.bugfree.instacare.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {



    private AddressService addressService = null;

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/default/{userId}")
    @ResponseBody
    public ResponseBean getDefaultAddressByUserId(@PathVariable String userId) throws Exception {
        AddressBean ans = addressService.getDefaultAddressByUserId(userId);
        return new ResponseBean(200, "OK", ans);
    }

    @PutMapping("/default/{userId}/{addressId}")
    @ResponseBody
    public ResponseBean setDefaultAddress(@PathVariable String userId,@PathVariable String addressId) throws Exception {
        String ans = addressService.updateDefaultAddress(userId,addressId);
        return new ResponseBean(200, "OK", ans);
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public ResponseBean getAddressByUserId(@PathVariable String userId) throws Exception {
        List<AddressBean> ans = addressService.getAddressByUserId(userId);
        return new ResponseBean(200, "OK", ans);
    }


    @GetMapping("/{userId}/{addressId}")
    @ResponseBody
    public ResponseBean getAddressByAddressId(@PathVariable String userId,@PathVariable String addressId) throws Exception {
        AddressBean ans = addressService.getAddressByAddressId(userId,addressId);
        return new ResponseBean(200, "OK", ans);
    }

    @PostMapping("/{userId}")
    @ResponseBody
    public ResponseBean insertAddress(@PathVariable String userId,@RequestBody AddressBean addressBean) throws Exception {
        String ans = addressService.insertAddress(userId,addressBean );
        return new ResponseBean(200, "OK", ans);
    }


    @PutMapping("/{userId}/{addressId}")
    @ResponseBody
    public ResponseBean updateAddress(@PathVariable String userId,@PathVariable String addressId, @RequestBody Map<String, Object> updateData ) throws Exception {
        String ans = addressService.updateAddress(userId,addressId,updateData);
        return new ResponseBean(200, "OK", ans);
    }

    @DeleteMapping("/{userId}/{addressId}")
    @ResponseBody
    public ResponseBean deleteAddress(@PathVariable String userId,@PathVariable String addressId) throws Exception {
        String ans = addressService.deleteAddress(userId,addressId);
        return new ResponseBean(200, "OK", ans);
    }

}
