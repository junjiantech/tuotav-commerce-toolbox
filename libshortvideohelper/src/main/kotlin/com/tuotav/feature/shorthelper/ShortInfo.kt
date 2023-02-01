package com.tuotav.feature.shorthelper

import com.google.gson.annotations.SerializedName

/**
 * ===============================================
 * 短视频分享信息 (针对外部展现的)
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/2/1 15:36
 */
data class ShortInformationViewObject(
    // 用户头像
    val avatar: String,
    val avatarThumb: String,
    // 作者昵称
    val nickname: String,
    // 作者个性签名
    val signature: String,
    // 用户唯一标识
    val uId: String,
    // 视频标题
    val title: String,
    // 背景音乐
    val music: String?,
    // 视频播放地址
    val video: String? = null,
    // 图集列表
    val images: List<String>,
)


/**
 * ===============================================
 * 抖音视频响应信息.
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/2/1 15:36
 */
data class DouyinVideoInformationResponse(
    @SerializedName("aweme_detail")
    val awemeDetail: AwemeDetail,
    @SerializedName("log_pb")
    val logPb: LogPb,
    @SerializedName("status_code")
    val statusCode: Int
) {
    data class AwemeDetail(
        @SerializedName("admire_auth")
        val admireAuth: AdmireAuth,
        @SerializedName("anchors")
        val anchors: Any,
        @SerializedName("author")
        val author: Author,
        @SerializedName("author_mask_tag")
        val authorMaskTag: Int,
        @SerializedName("author_user_id")
        val authorUserId: Long,
        @SerializedName("aweme_control")
        val awemeControl: AwemeControl,
        @SerializedName("aweme_id")
        val awemeId: String,
        @SerializedName("aweme_type")
        val awemeType: Int,
        @SerializedName("challenge_position")
        val challengePosition: Any,
        @SerializedName("chapter_list")
        val chapterList: Any,
        @SerializedName("collect_stat")
        val collectStat: Int,
        @SerializedName("comment_gid")
        val commentGid: Long,
        @SerializedName("comment_list")
        val commentList: Any,
        @SerializedName("comment_permission_info")
        val commentPermissionInfo: CommentPermissionInfo,
        @SerializedName("commerce_config_data")
        val commerceConfigData: Any,
        @SerializedName("common_bar_info")
        val commonBarInfo: String,
        @SerializedName("component_info_v2")
        val componentInfoV2: String,
        @SerializedName("cover_labels")
        val coverLabels: Any,
        @SerializedName("create_time")
        val createTime: Int,
        @SerializedName("desc")
        val desc: String,
        @SerializedName("digg_lottie")
        val diggLottie: DiggLottie,
        @SerializedName("disable_relation_bar")
        val disableRelationBar: Int,
        @SerializedName("dislike_dimension_list")
        val dislikeDimensionList: Any,
        @SerializedName("duet_aggregate_in_music_tab")
        val duetAggregateInMusicTab: Boolean,
        @SerializedName("duration")
        val duration: Int,
        @SerializedName("feed_comment_config")
        val feedCommentConfig: FeedCommentConfig,
        @SerializedName("geofencing")
        val geofencing: List<Any>,
        @SerializedName("geofencing_regions")
        val geofencingRegions: Any,
        @SerializedName("group_id")
        val groupId: String,
        @SerializedName("hybrid_label")
        val hybridLabel: Any,
        @SerializedName("image_album_music_info")
        val imageAlbumMusicInfo: ImageAlbumMusicInfo,
        @SerializedName("image_infos")
        val imageInfos: Any,
        @SerializedName("image_list")
        val imageList: Any,
        @SerializedName("images")
        val images: DouyinImage?,
        @SerializedName("img_bitrate")
        val imgBitrate: Any,
        @SerializedName("impression_data")
        val impressionData: ImpressionData,
        @SerializedName("interaction_stickers")
        val interactionStickers: Any,
        @SerializedName("is_ads")
        val isAds: Boolean,
        @SerializedName("is_collects_selected")
        val isCollectsSelected: Int,
        @SerializedName("is_duet_sing")
        val isDuetSing: Boolean,
        @SerializedName("is_image_beat")
        val isImageBeat: Boolean,
        @SerializedName("is_life_item")
        val isLifeItem: Boolean,
        @SerializedName("is_story")
        val isStory: Int,
        @SerializedName("is_top")
        val isTop: Int,
        @SerializedName("item_warn_notification")
        val itemWarnNotification: ItemWarnNotification,
        @SerializedName("label_top_text")
        val labelTopText: Any,
        @SerializedName("long_video")
        val longVideo: Any,
        @SerializedName("music")
        val music: Music,
        @SerializedName("nickname_position")
        val nicknamePosition: Any,
        @SerializedName("origin_comment_ids")
        val originCommentIds: Any,
        @SerializedName("origin_text_extra")
        val originTextExtra: List<Any>,
        @SerializedName("original_images")
        val originalImages: Any,
        @SerializedName("packed_clips")
        val packedClips: Any,
        @SerializedName("photo_search_entrance")
        val photoSearchEntrance: PhotoSearchEntrance,
        @SerializedName("position")
        val position: Any,
        @SerializedName("press_panel_info")
        val pressPanelInfo: String,
        @SerializedName("preview_title")
        val previewTitle: String,
        @SerializedName("preview_video_status")
        val previewVideoStatus: Int,
        @SerializedName("promotions")
        val promotions: List<Any>,
        @SerializedName("rate")
        val rate: Int,
        @SerializedName("region")
        val region: String,
        @SerializedName("relation_labels")
        val relationLabels: Any,
        @SerializedName("search_impr")
        val searchImpr: SearchImpr,
        @SerializedName("series_paid_info")
        val seriesPaidInfo: SeriesPaidInfo,
        @SerializedName("share_info")
        val shareInfo: ShareInfo,
        @SerializedName("share_url")
        val shareUrl: String,
        @SerializedName("should_open_ad_report")
        val shouldOpenAdReport: Boolean,
        @SerializedName("show_follow_button")
        val showFollowButton: ShowFollowButton,
        @SerializedName("social_tag_list")
        val socialTagList: Any,
        @SerializedName("standard_bar_info_list")
        val standardBarInfoList: Any,
        @SerializedName("statistics")
        val statistics: Statistics,
        @SerializedName("status")
        val status: Status,
        @SerializedName("suggest_words")
        val suggestWords: SuggestWords,
        @SerializedName("text_extra")
        val textExtra: List<Any>,
        @SerializedName("uniqid_position")
        val uniqidPosition: Any,
        @SerializedName("user_digged")
        val userDigged: Int,
        @SerializedName("video")
        val video: Video,
        @SerializedName("video_labels")
        val videoLabels: Any,
        @SerializedName("video_tag")
        val videoTag: List<VideoTag>,
        @SerializedName("video_text")
        val videoText: List<Any>,
        @SerializedName("wanna_tag")
        val wannaTag: WannaTag
    ) {
        data class AdmireAuth(
            @SerializedName("admire_button")
            val admireButton: Int,
            @SerializedName("is_admire")
            val isAdmire: Int,
            @SerializedName("is_show_admire_button")
            val isShowAdmireButton: Int,
            @SerializedName("is_show_admire_tab")
            val isShowAdmireTab: Int
        )

        data class Author(
            @SerializedName("avatar_thumb")
            val avatarThumb: AvatarThumb,
            @SerializedName("cf_list")
            val cfList: Any,
            @SerializedName("close_friend_type")
            val closeFriendType: Int,
            @SerializedName("contacts_status")
            val contactsStatus: Int,
            @SerializedName("contrail_list")
            val contrailList: Any,
            @SerializedName("cover_url")
            val coverUrl: List<CoverUrl>,
            @SerializedName("create_time")
            val createTime: Int,
            @SerializedName("custom_verify")
            val customVerify: String,
            @SerializedName("data_label_list")
            val dataLabelList: Any,
            @SerializedName("endorsement_info_list")
            val endorsementInfoList: Any,
            @SerializedName("enterprise_verify_reason")
            val enterpriseVerifyReason: String,
            @SerializedName("favoriting_count")
            val favoritingCount: Int,
            @SerializedName("follow_status")
            val followStatus: Int,
            @SerializedName("follower_count")
            val followerCount: Int,
            @SerializedName("follower_list_secondary_information_struct")
            val followerListSecondaryInformationStruct: Any,
            @SerializedName("follower_status")
            val followerStatus: Int,
            @SerializedName("following_count")
            val followingCount: Int,
            @SerializedName("im_role_ids")
            val imRoleIds: Any,
            @SerializedName("is_ad_fake")
            val isAdFake: Boolean,
            @SerializedName("is_blocked_v2")
            val isBlockedV2: Boolean,
            @SerializedName("is_blocking_v2")
            val isBlockingV2: Boolean,
            @SerializedName("is_cf")
            val isCf: Int,
            @SerializedName("max_follower_count")
            val maxFollowerCount: Int,
            @SerializedName("nickname")
            val nickname: String,
            @SerializedName("not_seen_item_id_list")
            val notSeenItemIdList: Any,
            @SerializedName("not_seen_item_id_list_v2")
            val notSeenItemIdListV2: Any,
            @SerializedName("offline_info_list")
            val offlineInfoList: Any,
            @SerializedName("personal_tag_list")
            val personalTagList: Any,
            @SerializedName("prevent_download")
            val preventDownload: Boolean,
            @SerializedName("risk_notice_text")
            val riskNoticeText: String,
            @SerializedName("sec_uid")
            val secUid: String,
            @SerializedName("secret")
            val secret: Int,
            @SerializedName("share_info")
            val shareInfo: ShareInfo,
            @SerializedName("short_id")
            val shortId: String,
            @SerializedName("signature")
            val signature: String,
            @SerializedName("signature_extra")
            val signatureExtra: Any,
            @SerializedName("special_people_labels")
            val specialPeopleLabels: Any,
            @SerializedName("status")
            val status: Int,
            @SerializedName("text_extra")
            val textExtra: Any,
            @SerializedName("total_favorited")
            val totalFavorited: Int,
            @SerializedName("uid")
            val uid: String,
            @SerializedName("unique_id")
            val uniqueId: String,
            @SerializedName("user_age")
            val userAge: Int,
            @SerializedName("user_canceled")
            val userCanceled: Boolean,
            @SerializedName("user_permissions")
            val userPermissions: Any,
            @SerializedName("verification_type")
            val verificationType: Int
        ) {
            data class AvatarThumb(
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class CoverUrl(
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class ShareInfo(
                @SerializedName("share_desc")
                val shareDesc: String,
                @SerializedName("share_desc_info")
                val shareDescInfo: String,
                @SerializedName("share_qrcode_url")
                val shareQrcodeUrl: ShareQrcodeUrl,
                @SerializedName("share_title")
                val shareTitle: String,
                @SerializedName("share_title_myself")
                val shareTitleMyself: String,
                @SerializedName("share_title_other")
                val shareTitleOther: String,
                @SerializedName("share_url")
                val shareUrl: String,
                @SerializedName("share_weibo_desc")
                val shareWeiboDesc: String
            ) {
                data class ShareQrcodeUrl(
                    @SerializedName("height")
                    val height: Int,
                    @SerializedName("uri")
                    val uri: String,
                    @SerializedName("url_list")
                    val urlList: List<String>,
                    @SerializedName("width")
                    val width: Int
                )
            }
        }

        data class AwemeControl(
            @SerializedName("can_comment")
            val canComment: Boolean,
            @SerializedName("can_forward")
            val canForward: Boolean,
            @SerializedName("can_share")
            val canShare: Boolean,
            @SerializedName("can_show_comment")
            val canShowComment: Boolean
        )

        data class CommentPermissionInfo(
            @SerializedName("can_comment")
            val canComment: Boolean,
            @SerializedName("comment_permission_status")
            val commentPermissionStatus: Int,
            @SerializedName("item_detail_entry")
            val itemDetailEntry: Boolean,
            @SerializedName("press_entry")
            val pressEntry: Boolean,
            @SerializedName("toast_guide")
            val toastGuide: Boolean
        )

        data class DiggLottie(
            @SerializedName("can_bomb")
            val canBomb: Int,
            @SerializedName("lottie_id")
            val lottieId: String
        )

        data class FeedCommentConfig(
            @SerializedName("author_audit_status")
            val authorAuditStatus: Int,
            @SerializedName("input_config_text")
            val inputConfigText: String
        )

        data class ImageAlbumMusicInfo(
            @SerializedName("begin_time")
            val beginTime: Int,
            @SerializedName("end_time")
            val endTime: Int,
            @SerializedName("volume")
            val volume: Int
        )

        data class ImpressionData(
            @SerializedName("group_id_list_a")
            val groupIdListA: List<Long>,
            @SerializedName("group_id_list_b")
            val groupIdListB: List<Long>,
            @SerializedName("similar_id_list_a")
            val similarIdListA: List<Int>,
            @SerializedName("similar_id_list_b")
            val similarIdListB: Any
        )

        data class ItemWarnNotification(
            @SerializedName("content")
            val content: String,
            @SerializedName("show")
            val show: Boolean,
            @SerializedName("type")
            val type: Int
        )

        data class Music(
            @SerializedName("album")
            val album: String,
            @SerializedName("artist_user_infos")
            val artistUserInfos: Any,
            @SerializedName("artists")
            val artists: List<Any>,
            @SerializedName("audition_duration")
            val auditionDuration: Int,
            @SerializedName("author")
            val author: String,
            @SerializedName("author_deleted")
            val authorDeleted: Boolean,
            @SerializedName("author_position")
            val authorPosition: Any,
            @SerializedName("author_status")
            val authorStatus: Int,
            @SerializedName("avatar_large")
            val avatarLarge: AvatarLarge,
            @SerializedName("avatar_medium")
            val avatarMedium: AvatarMedium,
            @SerializedName("avatar_thumb")
            val avatarThumb: AvatarThumb,
            @SerializedName("binded_challenge_id")
            val bindedChallengeId: Int,
            @SerializedName("can_background_play")
            val canBackgroundPlay: Boolean,
            @SerializedName("collect_stat")
            val collectStat: Int,
            @SerializedName("cover_hd")
            val coverHd: CoverHd,
            @SerializedName("cover_large")
            val coverLarge: CoverLarge,
            @SerializedName("cover_medium")
            val coverMedium: CoverMedium,
            @SerializedName("cover_thumb")
            val coverThumb: CoverThumb,
            @SerializedName("dmv_auto_show")
            val dmvAutoShow: Boolean,
            @SerializedName("dsp_status")
            val dspStatus: Int,
            @SerializedName("duration")
            val duration: Int,
            @SerializedName("end_time")
            val endTime: Int,
            @SerializedName("external_song_info")
            val externalSongInfo: List<Any>,
            @SerializedName("extra")
            val extra: String,
            @SerializedName("id")
            val id: Long,
            @SerializedName("id_str")
            val idStr: String,
            @SerializedName("is_audio_url_with_cookie")
            val isAudioUrlWithCookie: Boolean,
            @SerializedName("is_commerce_music")
            val isCommerceMusic: Boolean,
            @SerializedName("is_del_video")
            val isDelVideo: Boolean,
            @SerializedName("is_matched_metadata")
            val isMatchedMetadata: Boolean,
            @SerializedName("is_original")
            val isOriginal: Boolean,
            @SerializedName("is_original_sound")
            val isOriginalSound: Boolean,
            @SerializedName("is_pgc")
            val isPgc: Boolean,
            @SerializedName("is_restricted")
            val isRestricted: Boolean,
            @SerializedName("is_video_self_see")
            val isVideoSelfSee: Boolean,
            @SerializedName("luna_info")
            val lunaInfo: LunaInfo,
            @SerializedName("lyric_short_position")
            val lyricShortPosition: Any,
            @SerializedName("mid")
            val mid: String,
            @SerializedName("music_chart_ranks")
            val musicChartRanks: Any,
            @SerializedName("music_status")
            val musicStatus: Int,
            @SerializedName("musician_user_infos")
            val musicianUserInfos: Any,
            @SerializedName("mute_share")
            val muteShare: Boolean,
            @SerializedName("offline_desc")
            val offlineDesc: String,
            @SerializedName("owner_handle")
            val ownerHandle: String,
            @SerializedName("owner_id")
            val ownerId: String,
            @SerializedName("owner_nickname")
            val ownerNickname: String,
            @SerializedName("pgc_music_type")
            val pgcMusicType: Int,
            @SerializedName("play_url")
            val playUrl: PlayUrl,
            @SerializedName("position")
            val position: Any,
            @SerializedName("prevent_download")
            val preventDownload: Boolean,
            @SerializedName("prevent_item_download_status")
            val preventItemDownloadStatus: Int,
            @SerializedName("preview_end_time")
            val previewEndTime: Int,
            @SerializedName("preview_start_time")
            val previewStartTime: Int,
            @SerializedName("reason_type")
            val reasonType: Int,
            @SerializedName("redirect")
            val redirect: Boolean,
            @SerializedName("schema_url")
            val schemaUrl: String,
            @SerializedName("search_impr")
            val searchImpr: SearchImpr,
            @SerializedName("sec_uid")
            val secUid: String,
            @SerializedName("shoot_duration")
            val shootDuration: Int,
            @SerializedName("source_platform")
            val sourcePlatform: Int,
            @SerializedName("start_time")
            val startTime: Int,
            @SerializedName("status")
            val status: Int,
            @SerializedName("tag_list")
            val tagList: Any,
            @SerializedName("title")
            val title: String,
            @SerializedName("unshelve_countries")
            val unshelveCountries: Any,
            @SerializedName("user_count")
            val userCount: Int,
            @SerializedName("video_duration")
            val videoDuration: Int
        ) {
            data class AvatarLarge(
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class AvatarMedium(
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class AvatarThumb(
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class CoverHd(
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class CoverLarge(
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class CoverMedium(
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class CoverThumb(
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class LunaInfo(
                @SerializedName("is_luna_user")
                val isLunaUser: Boolean
            )

            data class PlayUrl(
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_key")
                val urlKey: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class SearchImpr(
                @SerializedName("entity_id")
                val entityId: String
            )
        }

        data class PhotoSearchEntrance(
            @SerializedName("ecom_type")
            val ecomType: Int
        )

        data class SearchImpr(
            @SerializedName("entity_id")
            val entityId: String,
            @SerializedName("entity_type")
            val entityType: String
        )

        data class SeriesPaidInfo(
            @SerializedName("item_price")
            val itemPrice: Int,
            @SerializedName("series_paid_status")
            val seriesPaidStatus: Int
        )

        data class ShareInfo(
            @SerializedName("share_desc")
            val shareDesc: String,
            @SerializedName("share_desc_info")
            val shareDescInfo: String,
            @SerializedName("share_link_desc")
            val shareLinkDesc: String,
            @SerializedName("share_url")
            val shareUrl: String
        )

        class ShowFollowButton

        data class Statistics(
            @SerializedName("admire_count")
            val admireCount: Int,
            @SerializedName("aweme_id")
            val awemeId: String,
            @SerializedName("collect_count")
            val collectCount: Int,
            @SerializedName("comment_count")
            val commentCount: Int,
            @SerializedName("digg_count")
            val diggCount: Int,
            @SerializedName("play_count")
            val playCount: Int,
            @SerializedName("share_count")
            val shareCount: Int
        )

        data class Status(
            @SerializedName("allow_share")
            val allowShare: Boolean,
            @SerializedName("aweme_id")
            val awemeId: String,
            @SerializedName("in_reviewing")
            val inReviewing: Boolean,
            @SerializedName("is_delete")
            val isDelete: Boolean,
            @SerializedName("is_prohibited")
            val isProhibited: Boolean,
            @SerializedName("listen_video_status")
            val listenVideoStatus: Int,
            @SerializedName("part_see")
            val partSee: Int,
            @SerializedName("private_status")
            val privateStatus: Int,
            @SerializedName("review_result")
            val reviewResult: ReviewResult
        ) {
            data class ReviewResult(
                @SerializedName("review_status")
                val reviewStatus: Int
            )
        }

        data class SuggestWords(
            @SerializedName("suggest_words")
            val suggestWords: List<SuggestWord>
        ) {
            data class SuggestWord(
                @SerializedName("extra_info")
                val extraInfo: String,
                @SerializedName("hint_text")
                val hintText: String,
                @SerializedName("icon_url")
                val iconUrl: String,
                @SerializedName("scene")
                val scene: String,
                @SerializedName("words")
                val words: List<Word>
            ) {
                data class Word(
                    @SerializedName("info")
                    val info: String,
                    @SerializedName("word")
                    val word: String,
                    @SerializedName("word_id")
                    val wordId: String
                )
            }
        }

        data class Video(
            @SerializedName("big_thumbs")
            val bigThumbs: Any,
            @SerializedName("bit_rate")
            val bitRate: List<BitRate>,
            @SerializedName("cover")
            val cover: Cover,
            @SerializedName("cover_original_scale")
            val coverOriginalScale: CoverOriginalScale,
            @SerializedName("duration")
            val duration: Int,
            @SerializedName("dynamic_cover")
            val dynamicCover: DynamicCover,
            @SerializedName("height")
            val height: Int,
            @SerializedName("is_h265")
            val isH265: Int,
            @SerializedName("is_source_HDR")
            val isSourceHDR: Int,
            @SerializedName("meta")
            val meta: String,
            @SerializedName("origin_cover")
            val originCover: OriginCover,
            @SerializedName("play_addr")
            val playAddr: PlayAddr,
            @SerializedName("play_addr_265")
            val playAddr265: PlayAddr265,
            @SerializedName("play_addr_h264")
            val playAddrH264: PlayAddrH264,
            @SerializedName("ratio")
            val ratio: String,
            @SerializedName("width")
            val width: Int
        ) {
            data class BitRate(
                @SerializedName("bit_rate")
                val bitRate: Int,
                @SerializedName("FPS")
                val fPS: Int,
                @SerializedName("gear_name")
                val gearName: String,
                @SerializedName("HDR_bit")
                val hDRBit: String,
                @SerializedName("HDR_type")
                val hDRType: String,
                @SerializedName("is_bytevc1")
                val isBytevc1: Int,
                @SerializedName("is_h265")
                val isH265: Int,
                @SerializedName("play_addr")
                val playAddr: PlayAddr,
                @SerializedName("quality_type")
                val qualityType: Int
            ) {
                data class PlayAddr(
                    @SerializedName("data_size")
                    val dataSize: Int,
                    @SerializedName("file_cs")
                    val fileCs: String,
                    @SerializedName("file_hash")
                    val fileHash: String,
                    @SerializedName("height")
                    val height: Int,
                    @SerializedName("uri")
                    val uri: String,
                    @SerializedName("url_key")
                    val urlKey: String,
                    @SerializedName("url_list")
                    val urlList: List<String>,
                    @SerializedName("width")
                    val width: Int
                )
            }

            data class Cover(
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class CoverOriginalScale(
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class DynamicCover(
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class OriginCover(
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class PlayAddr(
                @SerializedName("data_size")
                val dataSize: Int,
                @SerializedName("file_cs")
                val fileCs: String,
                @SerializedName("file_hash")
                val fileHash: String,
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_key")
                val urlKey: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class PlayAddr265(
                @SerializedName("data_size")
                val dataSize: Int,
                @SerializedName("file_cs")
                val fileCs: String,
                @SerializedName("file_hash")
                val fileHash: String,
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_key")
                val urlKey: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )

            data class PlayAddrH264(
                @SerializedName("data_size")
                val dataSize: Int,
                @SerializedName("file_cs")
                val fileCs: String,
                @SerializedName("file_hash")
                val fileHash: String,
                @SerializedName("height")
                val height: Int,
                @SerializedName("uri")
                val uri: String,
                @SerializedName("url_key")
                val urlKey: String,
                @SerializedName("url_list")
                val urlList: List<String>,
                @SerializedName("width")
                val width: Int
            )
        }

        data class VideoTag(
            @SerializedName("level")
            val level: Int,
            @SerializedName("tag_id")
            val tagId: Int,
            @SerializedName("tag_name")
            val tagName: String
        )

        class WannaTag
    }

    data class DouyinImage(
        @SerializedName("mask_url_list")
        val maskUrlList: String,
        val uri: String,
        @SerializedName("url_list")
        val urlList: List<String>
    )

    data class LogPb(
        @SerializedName("impr_id")
        val imprId: String
    )
}