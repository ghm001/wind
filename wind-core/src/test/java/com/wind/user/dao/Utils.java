package com.wind.user.dao;

import com.wind.carMessage.model.ByscVO;

/**
 * Created by Administrator on 2016/8/10.
 */
public class Utils {
    //用于检测保养手册中,汽车各零件的状态  0代表正常 1代表需要检查 2代表必须更换 3代表数据不支持
    private static int loopNum=8;//循环次数
    private static int baseKm=5000;//公里数基准
    //机油机率状态判断
    public static ByscVO jyjlState(double num){
        ByscVO byscVO=new ByscVO();
        byscVO.setByxmName("机油机滤");
        byscVO.setByscNum(1);
       for (int i=0;i<loopNum;i++){
         if(num>=(i+1)*baseKm&&num<=(i+1)*baseKm+500){
             //需要更换
             byscVO.setByxmState(2);
             return byscVO;
         }

           if(num>42000){
               //当大于4.2万公里的时候，数据不支持。
               byscVO.setByxmState(3);
               return byscVO;
           }
       }
        byscVO.setByxmState(0);
        return byscVO;
    }

    //空滤状态判断
    public static ByscVO klState(double num){
        ByscVO byscVO=new ByscVO();
        byscVO.setByxmName("空滤");
        byscVO.setByscNum(2);
        for(int i=0;i<loopNum;i++){
           if(i%3==0||i%3==1){
               if(num>=(i+1)*baseKm&&num<=(i+1)*baseKm+500){
                   //需要更换
                   byscVO.setByxmState(1);
                   return byscVO;
               }
           }

            if(i%3==2){
                if(num>=(i+1)*baseKm&&num<=(i+1)*baseKm+500){
                    //需要更换
                    byscVO.setByxmState(2);
                    return byscVO;
                }
            }
        }

        if(num>42000){
            //当大于4.2万公里的时候，数据不支持。
            byscVO.setByxmState(3);
            return byscVO;
        }
        byscVO.setByxmState(0);
        return byscVO;
    }

    //空调滤芯状态判断
    public static ByscVO ktlxState(double num){
        ByscVO byscVO=new ByscVO();
        byscVO.setByxmName("空调滤芯");
        byscVO.setByscNum(3);
        for(int i=0;i<loopNum;i++){
            if(i%3==0||i%3==1){
                if(num>=(i+1)*baseKm&&num<=(i+1)*baseKm+500){
                    //需要更换
                    byscVO.setByxmState(1);
                    return byscVO;
                }
            }

            if(i%3==2){
                if(num>=(i+1)*baseKm&&num<=(i+1)*baseKm+500){
                    //需要更换
                    byscVO.setByxmState(2);
                    return byscVO;
                }
            }
        }

        if(num>42000){
            //当大于4.2万公里的时候，数据不支持。
            byscVO.setByxmState(3);
            return byscVO;
        }
        byscVO.setByxmState(0);
        return byscVO;

    }

    //汽滤状态判断
    public static ByscVO bsxyState(double num){
        ByscVO byscVO=new ByscVO();
        byscVO.setByxmName("汽滤");
        byscVO.setByscNum(4);
        for (int i=0;i<loopNum;i++){
            if(num>=(i+1)*baseKm&&num<=(i+1)*baseKm+500){
                //需要检查
                byscVO.setByxmState(1);
                return byscVO;
            }

            if(num>42000){
                //当大于4.2万公里的时候，数据不支持。
                byscVO.setByxmState(3);
                return byscVO;
            }
        }
        byscVO.setByxmState(0);
        return byscVO;
    }

    //变速箱油状态判断
    public static ByscVO zxyState(double num){
        ByscVO byscVO=new ByscVO();
        byscVO.setByxmName("变速箱油");
        byscVO.setByscNum(5);
        for(int i=0;i<loopNum;i++){
            if(i!=(loopNum-1)){
                if(num>=((i+1)*baseKm)&&num<=((i+1)*baseKm)+500){
                   byscVO.setByxmState(1);
                   return byscVO;
                }
            }else if(i==(loopNum-1)){
                if(num>=((i+1)*baseKm)&&num<=((i+1)*baseKm)+500){
                    byscVO.setByxmState(2);
                    return byscVO;
                }
            }
        }
        if(num>42000){
            //当大于4.2万公里的时候，数据不支持。
            byscVO.setByxmState(3);
            return byscVO;
        }
        byscVO.setByxmState(0);
        return byscVO;
    }

    //转向油状态判断
    public static ByscVO zxtState(double num){
        ByscVO byscVO=new ByscVO();
        byscVO.setByxmName("转向油");
        byscVO.setByscNum(6);
        for (int i=0;i<loopNum;i++){
            if(num>=(i+1)*baseKm&&num<=(i+1)*baseKm+500){
                //需要检查
                byscVO.setByxmState(1);
                return byscVO;
            }

            if(num>42000){
                //当大于4.2万公里的时候，数据不支持。
                byscVO.setByxmState(3);
                return byscVO;
            }
        }
        byscVO.setByxmState(0);
        return byscVO;
    }

    //火花塞状态判断
    public static ByscVO hhsState(double num){
        ByscVO byscVO=new ByscVO();
        byscVO.setByxmName("火花塞");
        byscVO.setByscNum(7);
        for(int i=0;i<loopNum;i++){
            if(i!=5){
                if(num>=((i+1)*baseKm)&&num<=((i+1)*baseKm)+500){
                    byscVO.setByxmState(1);
                    return byscVO;
                }
            }else if(i==5){
                if(num>=((i+1)*baseKm)&&num<=((i+1)*baseKm)+500){
                    byscVO.setByxmState(2);
                    return byscVO;
                }
            }
        }
        if(num>42000){
            //当大于4.2万公里的时候，数据不支持。
            byscVO.setByxmState(3);
            return byscVO;
        }
        byscVO.setByxmState(0);
        return byscVO;
    }

    //刹车油状态判断
    public static ByscVO scyState(double num){
        ByscVO byscVO=new ByscVO();
        byscVO.setByxmName("刹车油");
        byscVO.setByscNum(8);
        for(int i=0;i<loopNum;i++){
            if(i!=5){
                if(num>=((i+1)*baseKm)&&num<=((i+1)*baseKm)+500){
                    byscVO.setByxmState(1);
                    return byscVO;
                }
            }else if(i==5){
                if(num>=((i+1)*baseKm)&&num<=((i+1)*baseKm)+500){
                    byscVO.setByxmState(2);
                    return byscVO;
                }
            }
        }
        if(num>42000){
            //当大于4.2万公里的时候，数据不支持。
            byscVO.setByxmState(3);
            return byscVO;
        }
        byscVO.setByxmState(0);
        return byscVO;
    }
}
