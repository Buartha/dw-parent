package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: wangyg
 * @Date: 2021/6/29 19:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GCJSZhaoBiaoYiChangQingKuangBaoGao implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String	ebidsun_data_id	;
    private String	PLATFORM_CODE	;
    private String	PLATFORM_DEPARTMENT	;
    private String	PLATFORM_RESPONSIBLE	;
    private String	PLATFORM_RESPONSIBLE_PHONE	;
    private String	PLATFORM_RESPONSIBLE_UNIT	;
    private String	DATA_RESPONSIBLE_CODE	;
    private String	DATA_RESPONSIBLE	;
    private String	DATA_RESPONSIBLE_PHONE	;
    private String	tenderProjectCode	;
    private String	bidSectionCode	;
    private String	excepitonName	;
    private String	excepitonInfor	;
    private String	approvalResult	;
    private String	approvalTime	;
    private String	objectIdentifierCode	;
    private String	unifiedDealCode	;
    private String	exceptionStatus	;
    private String	exceptionReason	;
    private String	PLATFORM_NAME	;
    private String	projectIdentifierCode	;
    private String	ebidsun_society_envelope_data	;
    private int	ebidsun_society_encrypt_method	;
    private String	ebidsun_society_encrypt_publicKey	;
    private String	ebidsun_society_cipherString	;
    private String	ebidsun_government_envelope_data	;
    private int	ebidsun_government_encrypt_method	;
    private String	ebidsun_government_encrypt_publicKey	;
    private String	ebidsun_government_cipherString	;
    private int	ebidsun_chain_version	;
    private String	ebidsun_platform_id	;
   // private int	ebidsun_up_chain_time	;
    private String	ebidsun_channel_name	;
    private int	ebidsun_block_height	;
    private int	ebidsun_decrypt_status	;
    private String	ebidsun_data_channel_config_id	;
    private int	ebidsun_force_upload	;
    private String	ebidsun_uploader_catalog_id	;
    private int	ebidsun_uploader_catalog_chain_version	;
    private double	ebidsun_uploader_catalog_show_version	;
    private double	ebidsun_show_version	;
    private int	ebidsun_mask	;
    private String	ebidsun_extension	;
    private String	ebidsun_ctime	;
    private String	ebidsun_mtime	;
    private String	ebidsun_block_info	;
    private String	pid	;
    private int	ebidsun_data_version	;
    private String	ebidsun_conversion_app	;
    private String	ebidsun_society_canbe_decrypt_time	;
    private String	ebidsun_government_canbe_decrypt_time	;
    private String	ebidsun_data_upload_time	;
    private String	ebidsun_data_sequence_id	;

}
