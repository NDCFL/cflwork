webpackJsonp([0], {
    1: function (t, e, i) {
        "use strict";

        function n(t) {
            var e = new RegExp("(^|&)" + t + "=([^&]*)(&|$)", "i"), i = window.location.search.substr(1).match(e);
            return null != i ? i[2] : null
        }

        Object.defineProperty(e, "__esModule", {value: !0});
        var a = {
            setCookie: function (t, e, i) {
                var n = new Date;
                n.setTime(n.getTime() + 24 * i * 60 * 60 * 1e3);
                var a = "expires=" + n.toGMTString();
                document.cookie = i ? t + "=" + e + "; " + a : t + "=" + e + "; "
            }, getCookie: function (t) {
                for (var e = t + "=", i = document.cookie.split(";"), n = 0; n < i.length; n++) {
                    var a = i[n].trim();
                    if (0 == a.indexOf(e)) return a.substring(e.length, a.length)
                }
                return ""
            }, checkCookie: function (t) {
                this.getCookie(t)
            }, delCookie: function (t) {
                var e = this, i = new Date;
                i.setTime(i.getTime() - 1);
                var n = e.getCookie(t);
                null != n && (document.cookie = t + "=" + n + ";expires=" + i.toGMTString())
            }
        };
        e.getParamFromUrl = n, e.cookieOperate = a
    }, 14: function (e, i, n) {
        "use strict";
        (function (e) {
            function i(t) {
                return (t / 96 * 25.4).toFixed(2)
            }

            function a(t) {
                return (t / 96 * 25.4).toFixed(2)
            }

            function o(t) {
                return (t / 96 * 25.4).toFixed(1)
            }

            function s(t) {
                var i = e('<div id="notice-info"></div>');
                e('<p class="info-desc">' + t + "</p>").appendTo(i), i.appendTo(e("body"))
            }

            n(6);
            var p, d, r, m, l = n(4), b = n(1), h = {origin: ""}, u = h.origin, f = {
                    topicNameHint: "题目名称不能为空！",
                    startHint: "开始题号不能为空！",
                    endHint: "结束题号不能为空！",
                    choiceNumberHint: function () {
                        return e("#choice-name").text() + "不能为空！"
                    },
                    startNumIntHint: "开始题号只能为正整数！",
                    endNumIntHint: "结束题号只能为正整数！",
                    choiceNumIntHint: function () {
                        return e("#choice-name").text() + "只能为正整数！"
                    },
                    topicNumHint: "题号不能重复！"
                }, g = 1, v = 0, x = 0, k = [], w = {}, C = b.cookieOperate.getCookie("userTel"),
                y = b.cookieOperate.getCookie("7netticket"), T = (0, b.getParamFromUrl)("Guid"), M = "A4", H = !0,
                I = !1, N = 8, q = !1, A = !0, j = !1, B = "", O = 0, S = 0, D = 0, U = 0, z = 0, E = 0, P = 0, L = 1,
                F = 1, R = 1, G = {
                    autoOperation: function () {
                        var t = this;
                        e(".user-account").text(t.phoneOperation(C)), C ? T ? t.editCardInfo() : (p = 0, T = "000", t.inputOperation(".dtk-name .input-text", "请输入试卷名称")) : t.needLogin(u), t.subjectAddLayer(), t.basicOperation(), t.dtkType(), e("#notice-cancel,#notice-layer .close").bind("click", function () {
                            e("#notice-layer").hide()
                        }), e("#dtk-preview").bind("click", function () {
                            e.when(t.htmlContentOperation(!0)).done(function () {
                                w = {
                                    htmlContent: "" + e("#preview-container").html(),
                                    pageNumber: e(".mask .mask-bg").length,
                                    fenLan: v,
                                    fenYe: x,
                                    dtkName: "" + e("#page-container .dtk-name .input-text").val()
                                }, localStorage.removeItem("previewContent"), localStorage.setItem("previewContent", JSON.stringify(w)), e("#html-content").html(""), e("#container").html(""), window.open("./dtk-preview.html")
                            })
                        }), e("#dtk-save").bind("click", function () {
                            if (!e(".dtk-name .input-text").val()) return alert("试卷名不能为空");
                            s("正在为您保存，请稍等......"), e.when(t.htmlContentOperation(!1)).done(function () {
                                var i = (0, l.base64encode)((0, l.utf16to8)("" + e("#html-content").html()));
                                e.when(t.htmlContentOperation(!0)).done(function () {
                                    e("#container .dtk-name .input-text").html(e("#page-container .dtk-name .input-text").val());
                                    var n = '<!DOCTYPE html><html lang="en"><head><meta charset="UTF-8"><title>生成答题卡</title>\x3c!--[if lt IE 9]><script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"><\/script><![endif]--\x3e<style>@charset "utf-8";html,body,div,span,object,iframe,h1,h2,h3,h4,h5,h6,p,address,cite,code,del,em,img,strong,sub,sup,b,i,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,article,aside,canvas,details,figcaption,figure,footer,header,hgroup,menu,nav,section,summary,time,mark,audio,video{margin:0;padding:0;border:0;outline:0;font-size:100%;-webkit-text-size-adjust:none;-moz-text-size-adjust:none;-ms-text-size-adjust:none;text-size-adjust:none;-webkit-tap-highlight-color:transparent;-webkit-touch-callout:none}html,body{width:100%;height:100%}body{color:#000;position:relative;font-family:Times,"Times New Roman",SimSun-ExtB,SimSun,NSimSun,serif;font-size:12px;background:#fff}a{color:#000;outline:0}a:hover,a:link,a:active,a:visited{outline:0;text-decoration:none}input,textarea,button,select{appearance:none;-moz-appearance:none;-webkit-appearance:none;font-family:inherit;font-size:inherit;outline:0}textarea{resize:none;outline:0}input:focus,textarea:focus{outline:0}table{border-collapse:collapse}img{position:relative;border:0}.ul,.ol,.dl{list-style:none}html,body{margin:0;padding:0}td{min-height:18px;font-family:Times,"Times New Roman",SimSun-ExtB,SimSun,NSimSun,serif}body,p,div{word-wrap:break-word}p{margin:5px 0}table{border-collapse:collapse}img{border:0}noscript{display:none}table.ke-zeroborder td{border:1px dotted #AAA}img.ke-flash{border:1px solid #AAA;background-image:url(http://kindeditor.net/ke4/themes/common/flash.gif);background-position:center center;background-repeat:no-repeat;width:100px;height:100px}img.ke-rm{border:1px solid #AAA;background-image:url(http://kindeditor.net/ke4/themes/common/rm.gif);background-position:center center;background-repeat:no-repeat;width:100px;height:100px}img.ke-media{border:1px solid #AAA;background-image:url(http://kindeditor.net/ke4/themes/common/media.gif);background-position:center center;background-repeat:no-repeat;width:100px;height:100px}img.ke-anchor{border:1px dashed #666;width:16px;height:16px}.ke-script,.ke-noscript,.ke-display-none{display:none;font-size:0;width:0;height:0}.ke-pagebreak{border:1px dotted #AAA;font-size:0;height:2px}.clear{width:0;height:0;display:block;clear:both;overflow:hidden}.noFloat:after{content:".";display:block;height:0;clear:both;visibility:hidden;overflow:hidden}.userselect{-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none}body,p,div{word-wrap:break-word}#container:after{content:".";display:block;height:0;clear:both;visibility:hidden;overflow:hidden}.le{float:left}.mar-le{margin-left:5mm}.dtk-tips{width:100%;height:14mm;line-height:14mm;text-align:center;padding-bottom:3mm}.dtk-tips .tips{margin:0 13mm;display:inline-block}.dtk-tips img{vertical-align:middle}.dtk-name{text-align:center;height:16mm;font-size:16px;line-height:16mm}.dtk-name .input-text{width:100%;height:100%;border:0;text-align:center;display:block;font-size:16px}.dtk-basic-info{position:relative;width:100%;min-height:54mm}.dtk-basic-info .flow{width:50%}.dtk-basic-info .info-le span{display:inline-block}.dtk-basic-info .info-le dt{border:1px solid #000;width:40%;padding:0 3mm 3mm}.dtk-basic-info .info-le .item{margin-top:3mm}.dtk-basic-info .info-le dt,.dtk-basic-info .info-le dd{margin-top:5mm}.dtk-basic-info .info-le .student-t{font-weight:bold;line-height:5mm}.dtk-basic-info .samll-block{width:5mm;height:3mm;background:#000;border:1px solid #000;margin-right:5%;display:inline-block;margin-left:5mm}.dtk-basic-info .samll-block-bor{background:#fff}.dtk-basic-info .student-grid{border-bottom:1px solid #000;width:53mm;height:5mm}.dtk-basic-info .bor-le{border-left:1px solid #000}.dtk-basic-info .w96{width:25mm}.dtk-basic-info .info-ro{border:1px solid #000}.dtk-basic-info .info-le .wrong-example{margin-left:5mm}.dtk-basic-info .info-ri{position:absolute;right:0;top:0;min-width:64mm}.dtk-basic-info .bar-code{width:64mm;height:24mm;border:1px dashed #000;color:#808080;text-align:center;line-height:8mm;padding-top:4mm}.dtk-basic-info .admission-ticket{display:none}.dtk-basic-info .tab{border-collapse:collapse;border:1px solid #000;width:100%}.dtk-basic-info .tab th,.dtk-basic-info .tab td{border:1px solid #000;padding:1px 0;text-align:center}.give-points{width:94px;height:37px;border-left:1px solid #000;border-bottom:1px solid #000;position:absolute;right:0;top:0;z-index:2;line-height:37px}.give-points span{display:block;width:35px;border-right:1px solid #000;text-align:center}.give-points{width:94px;height:37px;border-left:1px solid #000;border-bottom:1px solid #000;position:absolute;right:0;top:0;z-index:2;line-height:37px}.give-points span{display:block;width:35px;border-right:1px solid #000;text-align:center}.name-title{font-size:14px;font-weight:bold;padding:5mm 0 3mm}.choice-content{border:1px solid #000;padding:1mm 1mm 2mm;position:relative}.choice-content li{float:left;margin:1mm 3.2mm 1mm 0;min-width:41mm}.choice-item{padding-top:1mm;color:#000}\n.choice-item span{display:inline-block;margin:0 .79mm}.choice-item .No{width:5mm;text-align:right}.edit-content{border:1px solid #000;position:relative;overflow:hidden}.dtk-editor{width:100%}.editor-div{position:relative;min-height:51mm;overflow:hidden;padding-top:1.3mm;font-size:12px;line-height:1.5;font-family:Times,"Times New Roman",SimSun-ExtB,SimSun,NSimSun,serif}.no-visible{visibility:hidden}.no-topbor{border-top:0}.choice-box,.filling-box,.answer-box,.composition-box,.composition-en-box{width:100%;position:relative}.composition-content{border:1px solid #000;position:relative;width:100%}.composition-content .composition-area{border-left:1px solid #000;border-right:1px solid #000;margin:3mm auto;width:174mm;position:relative}.composition-No{margin:4mm 4mm 0;height:10.05mm}.composition-No .edit-content{border:0}.composition-content .grid-num{position:absolute;z-index:3}.composition-area .grid{border:1px solid #000;border-left:0;width:7.67mm;height:8mm;margin-bottom:2mm;float:left;position:relative;z-index:2}.composition-area .no-rightbor{border-right:0}.col-red{color:red}.uesr-bar{padding-bottom:0}.page{height:297mm;position:relative;float:left;color:#000}.composition-box .editor-div{min-height:10mm}.No{width:10mm;display:inline-block;text-align:right;line-height:normal}.answer-box .No{width:auto;padding-left:5mm}.e-u{overflow:hidden;line-height:10.2mm}.No-w{text-align:left}.p-num{text-align:center;font-weight:bold;position:absolute;left:0;width:100%;bottom:0;font-size:14px;line-height:8mm}.p-num i{font-style:normal}.optional-desc{padding:2.65mm}.optional-title{font-size:16px;font-weight:bold}.optional-No,.optional-text{padding-top:2.65mm}.optional-text strong{font-size:14px;font-weight:bold}.optional-No .No-num{border:1px solid #000;padding:0 2.65mm;text-align:center;margin-left:2.65mm}</style></head><body><div id="preview-container">' + e("#preview-container").html() + "</div></body></html>";
                                    n = (0, l.base64encode)((0, l.utf16to8)(n)), k.length > 0 && (B = k.join(","));
                                    var a = {
                                        PaperName: "" + e(".dtk-name .input-text").val(),
                                        PaperType: M,
                                        IsBarcode: H,
                                        IsStudyNo: I,
                                        StudyNum: N,
                                        IsDisplayPageNum: q,
                                        IsDisplayQR: A,
                                        IsDisplayGFK: j,
                                        Guid: T,
                                        TopicTypeCount: B,
                                        SingleChoice: O,
                                        MultiChoice: S,
                                        FillBlank: D,
                                        AnswerQuestion: U,
                                        Composition: z,
                                        EnglishComposition: E,
                                        Content: i,
                                        Html: n,
                                        token: y
                                    };
                                    e.ajax({
                                        type: "POST",
                                        url: u + "/ExCard/createCard",
                                        data: a,
                                        dataType: "json",
                                        success: function (i) {
                                            "200" == i.status ? (e("#html-content").html(""), e("#container").html(""), location.href = "./index.html?Tel=" + C) : "403" == i.status && "Need Login" == i.message ? t.needLogin("" + i.data.Redirect) : alert(i.message)
                                        },
                                        error: function () {
                                        }
                                    })
                                })
                            })
                        }), e("#dtk-cancle").bind("click", function () {
                            location.href = "./index.html?Tel=" + C
                        }), e(".uesr-bar .exit").bind("click", function () {
                            b.cookieOperate.delCookie("userTel"), e.ajax({
                                type: "GET",
                                url: u + "/logout",
                                dataType: "json",
                                success: function (t) {
                                    "200" == t.status && (location.href = "" + t.data.Redirect)
                                }
                            })
                        })
                    }, phoneOperation: function (t) {
                        return t ? t.replace(/(\d{3})\d{4}(\d{4})/, "$1****$2") : ""
                    }, editCardInfo: function () {
                        var t = this;
                        e.ajax({
                            type: "POST",
                            url: u + "/ExCard/EditCardJson",
                            data: {Guid: T, token: y},
                            dataType: "json",
                            success: function (i) {
                                if ("200" == i.status) {
                                    var n = i.data.data;
                                    k = n.TopicTypeCount.split(","), 0 == k.length ? p = 0 : (k.sort(t.sortNumber), p = parseInt(k[k.length - 1])), "A3_3" == n.PaperType ? (e(".wrong-example").css({
                                        display: "block",
                                        margin: "5px 0 0"
                                    }), e(".mask").addClass("small-mask"), e(".dtk-content").css({
                                        width: "512px",
                                        padding: "10px 10px 0"
                                    })) : (e(".wrong-example").css({
                                        display: "inline-block",
                                        margin: "0 0 0 20px"
                                    }), e(".mask").removeClass("small-mask"), e(".dtk-content").css({
                                        width: "695px",
                                        padding: "10px 50px 0"
                                    })), e(".dtk-content").html((0, l.utf8to16)((0, l.base64decode)(n.Content))), e("#page-container .dtk-name .input-text").val(n.PaperName);
                                    for (var a = 0; a < e(".choice-box").length; a++) !function (i) {
                                        var n = !1, a = void 0;
                                        "radio-choice" == e(".choice-box").eq(i).attr("data-choice") && (n = !0), e(".choice-box .add").eq(i).unbind(), e(".choice-box .add").eq(i).bind("click", function () {
                                            function o(t) {
                                                "x" != t.charAt(t.length - 1) && "choice-box" == e("#" + t).attr("class") ? a = t : o("" + e("#" + t).prev().attr("id"))
                                            }

                                            o("" + e(".choice-box").eq(i).attr("id")), t.addItem("" + a, n)
                                        })
                                    }(a);
                                    switch (e(".composition-box .bi").unbind(), e(".composition-box .bi").bind("click", function () {
                                        var i = e(this);
                                        t.compositionBiOperation(i)
                                    }), e(".composition-box .max-hei").unbind(), e(".composition-box .max-hei").bind("click", function () {
                                        var i = "" + e(this).parents(".composition-box").attr("id");
                                        t.maxMinHeightCount(i, 0, i, parseInt(e("#" + i).attr("data-topic-total")))
                                    }), e(".composition-box .min-hei").unbind(), e(".composition-box .min-hei").bind("click", function () {
                                        var i = "" + e(this).parents(".composition-box").attr("id");
                                        t.maxMinHeightCount(i, 1, i, parseInt(e("#" + i).attr("data-topic-total")))
                                    }), e(".dtk-type .subfield").removeClass("cur"), "A3_2" == n.PaperType ? (v = 1, P = 1, e(".dtk-type .subfield").eq(1).addClass("cur")) : "A3_3" == n.PaperType ? (v = 2, P = 2, e(".dtk-type .subfield").eq(2).addClass("cur")) : (v = 0, P = 0, e(".dtk-type .subfield").eq(0).addClass("cur")), n.IsBarcode ? (e(".studyNo").removeClass("cur"), e(".barcode").addClass("cur")) : (e(".barcode").removeClass("cur"), e(".studyNo").addClass("cur")), n.StudyNum) {
                                        case 6:
                                            e("#slt-studyNo option").eq(0).attr("selected", !0);
                                            break;
                                        case 7:
                                            e("#slt-studyNo option").eq(1).attr("selected", !0);
                                            break;
                                        case 8:
                                            e("#slt-studyNo option").eq(2).attr("selected", !0);
                                            break;
                                        case 9:
                                            e("#slt-studyNo option").eq(3).attr("selected", !0);
                                            break;
                                        case 10:
                                            e("#slt-studyNo option").eq(4).attr("selected", !0);
                                            break;
                                        case 11:
                                            e("#slt-studyNo option").eq(5).attr("selected", !0);
                                            break;
                                        case 12:
                                            e("#slt-studyNo option").eq(6).attr("selected", !0);
                                            break;
                                        case 13:
                                            e("#slt-studyNo option").eq(7).attr("selected", !0)
                                    }
                                    e(".two-code .radio-style").removeClass("cur"), n.IsDisplayQR ? e(".two-code .radio-style").eq(0).addClass("cur") : e(".two-code .radio-style").eq(1).addClass("cur"), e(".is-give-points .radio-style").removeClass("cur"), n.IsDisplayGFK ? e(".is-give-points .radio-style").eq(0).addClass("cur") : e(".is-give-points .radio-style").eq(1).addClass("cur"), e(".is-page-footer .radio-style").removeClass("cur");
                                    var o = e(".mask").find(".mask-bg").length;
                                    if (n.IsDisplayPageNum) {
                                        e(".is-page-footer .radio-style").eq(0).addClass("cur"), x = 1;
                                        for (var s = 0; s < o; s++) e(".mask .mask-bg").eq(s).find(".foot-num").html('第<i class="cur-page-num">' + (s + 1) + '</i>页 共<i class="total-page-num">' + o + "</i>页")
                                    } else {
                                        e(".is-page-footer .radio-style").eq(1).addClass("cur"), x = 0;
                                        for (var d = 0; d < o; d++) e(".mask .mask-bg").eq(d).find(".foot-num").html('正<i class="cur-page-num">' + (d + 1) + "</i>")
                                    }
                                    for (var r = 0; r < e(".dtk-editor").length; r++) {
                                        var c, m;
                                        m = e(".dtk-editor").eq(r).parent(".edit-area").find(".operation-bar").length > 0 ? e(".dtk-editor").eq(r).parent(".edit-area").find(".operation-bar").attr("data-box") : e(".dtk-editor").eq(r).parents(".composition-No").next(".operation-bar").attr("data-box"), c = e(".dtk-editor").eq(r).parents("." + m).attr("id");
                                        var b = e("#" + c).find(".line-edit").attr("id"),
                                            h = e("#" + c).find(".edit-content").attr("id"),
                                            u = e("#" + c).find(".edit-area").attr("id"),
                                            f = e("#" + c).find(".dtk-editor").attr("id");
                                        b ? t.editorModule("", !0, "" + c, 0, "" + f, "" + b, "" + h, "" + u) : t.editorModule("", !1, "" + c, 0, "" + f, "" + b, "" + h, "" + u), e(".ke-container").css("width", "100%");
                                        var g = e(".dtk-editor").eq(r).css("height");
                                        e(".ke-edit").eq(r).css("height", g), e(".ke-edit-iframe").eq(r).css("height", g)
                                    }
                                    e(".composition-box").find(".ke-edit").height(e(".composition-box .composition-No").height()), e(".composition-box").find(".ke-edit-iframe").height(e(".composition-box .composition-No").height()), t.operationBarIsDis(".choice-box", 0, 0, 0, 1, 0, 0, 1), t.operationBarIsDis(".filling-box", 0, 0, 0, 0, 0, 0, 1), t.operationBarIsDis(".answer-box", 0, 0, 0, 0, 0, 0, 1), t.operationBarIsDis(".composition-box", 1, 1, 1, 0, 0, 0, 1), t.operationBarIsDis(".composition-en-box", 0, 0, 0, 0, 0, 0, 1), t.operationMergeBar(), t.operationBarDelOperation(), t.delOperationList(), t.addMask(), M = n.PaperType, H = n.IsBarcode, I = n.IsStudyNo, N = n.StudyNum, q = n.IsDisplayPageNum, A = n.IsDisplayQR, j = n.IsDisplayGFK, B = n.TopicTypeCount, O = n.SingleChoice, S = n.MultiChoice, D = n.FillBlank, U = n.AnswerQuestion, z = n.Composition, E = n.EnglishComposition
                                } else "403" == i.status && "Need Login" == i.message ? t.needLogin("" + i.data.Redirect) : alert(i.message)
                            },
                            error: function () {
                            }
                        })
                    }, htmlContentOperation: function (t) {
                        var i = this;
                        e("#html-content").html(e("#page-container .dtk-content").html()), e("#html-content .dtk-name .input-text").val(e("#page-container .dtk-name .input-text").val());
                        for (var n = e("#html-content .dtk-editor").length, o = 0; o < n; o++) {
                            var s = e(".dtk-content .edit-content").eq(o).height(),
                                p = e(".dtk-content .dtk-editor").eq(o).val();
                            e("#html-content .dtk-editor").eq(o).text(p), s <= 0 ? s = "auto" : e("#html-content .dtk-editor").eq(o).css("height", s), t && (e('<div class="editor-div"></div>').appendTo(e("#html-content .dtk-editor").eq(o).parents(".edit-content")), e("#html-content .edit-content").eq(o).css("height", a(s + 2) + "mm"), e("#html-content .edit-area").eq(o).css("height", "auto"), e("#html-content .editor-div").eq(o).html(p), e(".is-give-points .radio-style").eq(0).hasClass("cur") && (e("#html-content .editor-div").css("width", "85%"), e("#html-content .optional-desc").css("width", "85%"))), e("#html-content .ke-container").eq(0).remove()
                        }
                        e("#html-content .composition-box .dtk-editor").css("height", "auto"), t && (e(".e-u").each(function () {
                            e(this).children("span") && e(this).attr("style", e(this).children("span").attr("style"))
                        }), e("#html-content .composition-No").each(function () {
                            e(this).height(a(e(this).height()) + "mm")
                        }), e("#html-content .operation-bar").remove(), e("#html-content .line-edit").remove(), e("#html-content .merge").remove(), i.pageContentFun())
                    }, pageContentFun: function () {
                        for (var t, n, a = e(".mask .mask-bg").length, s = v, p = x, d = 0; d < a; d++) 2 == s ? (e("#container").css({width: o(1596) + "mm"}), t = e('<div class="page" style="width:' + i(512) + "mm ;padding:0 " + i(10) + 'mm 0;"></div>'), e("#html-content .choice-content li").css({margin: "1mm 2.8mm 1mm 0"}), e("#html-content .composition-box").css("width", i(512) + "mm "), e("#html-content .composition-content").css("width", i(510) + "mm "), e("#html-content .composition-area").css("width", i(479) + "mm")) : (e("#html-content .choice-content li").css({margin: "1mm 3.2mm 1mm 0"}), e("#html-content .composition-box").css("width", i(695) + "mm "), e("#html-content .composition-content").css("width", i(693) + "mm"), e("#html-content .composition-area").css("width", i(659) + "mm "), 1 == s ? e("#container").css({width: o(1590) + "mm"}) : e("#container").css({width: "210mm"}), t = e('<div class="page" style="width:' + i(695) + "mm;padding:0 " + i(50) + 'mm 0; "></div>')), t.appendTo(e("#container")), p && (n = e('<div class="p-num">第<i class="cur-page-num">' + (d + 1) + '</i>页 共<i class="total-page-num">' + a + "</i>页</div>"), n.appendTo(e("#container .page").eq(d)));
                        p ? (e("#html-content .dtk-tips").insertBefore(e("#container .page").eq(0).find(".p-num")), e("#html-content .dtk-name").insertBefore(e("#container .page").eq(0).find(".p-num")), e("#html-content .dtk-basic-info").insertBefore(e("#container .page").eq(0).find(".p-num"))) : (e("#html-content .dtk-tips").appendTo(e("#container .page").eq(0)), e("#html-content .dtk-name").appendTo(e("#container .page").eq(0)), e("#html-content .dtk-basic-info").appendTo(e("#container .page").eq(0)));
                        var r = e("#html-content .dtk-subject-main").children("div").length;
                        e("#html-content .choice-box,#html-content .filling-box,#html-content .answer-box,#html-content .composition-box,#html-content .composition-en-box").css({"margin-top": "0mm"});
                        for (var c = 0; c < r; c++) {
                            var m = e("#html-content .dtk-subject-main").children("div").eq(0).attr("data-page-number");
                            p ? e("#html-content .dtk-subject-main").children("div").eq(0).insertBefore(e("#container .page").eq(m - 1).find(".p-num")) : e("#html-content .dtk-subject-main").children("div").eq(0).appendTo(e("#container .page").eq(m - 1))
                        }
                        e("#container .page").find("div:first").css("margin-top", i(40) + "mm"), e("#container .page").eq(0).find("div:first").css("margin-top", i(20) + "mm")
                    }, subfieldRefresh: function (t) {
                        function i(t, e) {
                            switch (t) {
                                case"choice-box":
                                    a(e);
                                    break;
                                case"filling-box":
                                    o(e);
                                    break;
                                case"answer-box":
                                    s(e);
                                    break;
                                case"composition-box":
                                    p(e);
                                    break;
                                case"composition-en-box":
                                    d(e)
                            }
                        }

                        function n(t, a) {
                            if ("answer-box" == t) i(t, a); else if ("x" != a.charAt(a.length - 1)) e.when(i(t, a)).done(function () {
                                r.delOperationList()
                            }); else {
                                var o = e("#" + a).next().attr("class"), s = e("#" + a).next().attr("id");
                                s && n(o, s)
                            }
                        }

                        function a(t) {
                            var i = t, a = e("#" + i).attr("data-choice"), o = !0;
                            "multiple-choice" == a && (o = !1), e.when(r.choiceModule(o, !0, i, 0, 0, 0, 0, !0)).done(function () {
                                var t = e("#" + i).next().attr("class"), a = e("#" + i).next().attr("id");
                                a && n("" + t, "" + a)
                            }).fail(function () {
                                alert("出错啦！")
                            })
                        }

                        function o(t) {
                            function i(t) {
                                if (t) if (e("#" + t).hasClass("filling-box") && "x" == t.charAt(t.length - 1)) {
                                    var n = e("#" + t).next().attr("id"), a = parseInt(e("#" + t).attr("data-topic-num")),
                                        o = parseInt(e("#" + t).attr("data-topic-num-end"));
                                    e("#" + t).attr("data-topic-num") ? (l = l + o - a + 1, i(n)) : (p = e("#" + t).next().attr("id")) || (p = 0)
                                } else p = t; else p = 0
                            }

                            var a = t, o = e("#" + a).prev().attr("id");
                            o || (o = 0);
                            var s = e("#" + a).next().attr("id"), p = s;
                            p || (p = 0);
                            var d = e("#" + a).find(".name-title").text(),
                                c = parseInt(e("#" + a).attr("data-page-number")),
                                m = parseInt(e("#" + a).attr("data-topic-num")),
                                l = parseInt(e("#" + a).attr("data-topic-num-end")) - m + 1,
                                b = parseInt(e("#" + a).attr("data-row-num"));
                            e.when(i(s), r.delOperation("" + a, "filling-box"), r.editorAddModule("filling-box", 0, 0, 0, 0, !0, d, c, m, l + m - 1, b, o, p)).done(function () {
                                var t = e("#" + a).next().attr("class"), i = e("#" + a).next().attr("id");
                                i && n("" + t, "" + i)
                            }).fail(function () {
                                alert("出错啦！")
                            })
                        }

                        function s(t) {
                            e.when(r.myMarTopCount("" + t)).done(function () {
                                var i = e("#" + t).next().attr("class"), a = e("#" + t).next().attr("id");
                                a && n("" + i, "" + a)
                            }).fail(function () {
                                alert("出错啦！")
                            })
                        }

                        function p(t) {
                            var i = t, a = e("#" + i).prev().attr("id");
                            a || (a = 0);
                            var o = e("#" + i).next().attr("id");
                            e.when(r.findNextBoxX(o)).done(function () {
                                o = m
                            });
                            var s = parseInt(e("#" + i).attr("data-topic-total")),
                                p = e("#" + i).find(".name-title").text(),
                                d = parseInt(e("#" + i).attr("data-page-number")),
                                c = parseInt(e("#" + i).attr("data-topic-num"));
                            e.when(r.delOperation("" + i, "composition-box"), r.compositionModule(!1, 0, 0, 0, 0, "" + i, s, a, d, p, c, o)).done(function () {
                                var t = e("#" + i).next().attr("class"), a = e("#" + i).next().attr("id");
                                a && n("" + t, "" + a)
                            }).fail(function () {
                                alert("出错啦！")
                            })
                        }

                        function d(t) {
                            var i = t, a = e("#" + i).prev().attr("id");
                            a || (a = 0);
                            var o = e("#" + i).next().attr("id");
                            e.when(r.findNextBoxX(o)).done(function () {
                                o = m
                            });
                            var s = e("#" + i).find(".name-title").text(),
                                p = parseInt(e("#" + i).attr("data-page-number")),
                                d = parseInt(e("#" + i).attr("data-topic-num")),
                                c = parseInt(e("#" + i).attr("data-row-num"));
                            e.when(r.delOperation("" + i, "composition-en-box"), r.editorAddModule("composition-en-box", 0, 0, 0, 0, !0, s, p, d, "", c, a, o)).done(function () {
                                var t = e("#" + i).next().attr("class"), a = e("#" + i).next().attr("id");
                                a && n("" + t, "" + a)
                            }).fail(function () {
                                alert("出错啦！")
                            })
                        }

                        var r = this;
                        e(".ke-container").css({width: "100%"});
                        var c = e("#page-container .dtk-subject-main div:first").attr("class"),
                            l = e("#page-container .dtk-subject-main div:first").attr("id");
                        if (t) {
                            var b = e("#" + t);
                            c = b.nextAll().eq(0).attr("class"), l = b.nextAll().eq(0).attr("id")
                        }
                        e.when(i("" + c, "" + l)).done(function () {
                            r.delOperationList()
                        })
                    }, dtkType: function () {
                        var t = this, i = parseInt(e("#slt-studyNo").find("option:selected").text());
                        e(".dtk-type").each(function (n) {
                            e(this).unbind(), e(this).click(function () {
                                function a() {
                                    if (L) {
                                        if (L = 0, o.find(".subfield").hasClass("cur")) return void(L = 1);
                                        s("正在为您切换，请稍等......"), M = 0 == p ? "A4" : 1 == p ? "A3_2" : "A3_3", i = parseInt(e("#slt-studyNo").find("option:selected").text()), e(".dtk-type").find(".subfield").removeClass("cur"), o.find(".subfield").addClass("cur"), v = p, 2 == p ? (e(".wrong-example").css({
                                            display: "block",
                                            margin: "5px 0 0"
                                        }), e(".mask").addClass("small-mask"), e("#page-container .dtk-content").css({
                                            width: "512px",
                                            padding: "10px 10px 0"
                                        })) : (e(".wrong-example").css({
                                            display: "inline-block",
                                            margin: "0 0 0 20px"
                                        }), e(".mask").removeClass("small-mask"), e("#page-container .dtk-content").css({
                                            width: "695px",
                                            padding: "10px 50px 0"
                                        })), 2 == P || 2 == p ? e.when(t.subfieldRefresh()).done(function () {
                                            L = 1
                                        }) : L = 1, P = p, e("#notice-info").remove()
                                    }
                                }

                                var o = e(this), p = n;
                                e("#page-container .dtk-subject-main").children("div").length > 0 && (2 == P || 2 == p) ? (e("#notice-layer").show(), e("#notice-cancel").val("取消"), e("#notice-sure").unbind(), e("#notice-sure").bind("click", function () {
                                    a(), e("#notice-layer").hide()
                                })) : a()
                            })
                        })
                    }, basicOperation: function () {
                        var t = this;
                        e(".barcode").click(function () {
                            e(this).hasClass("cur") || (I = !1, H = !0, e(".studyNo").removeClass("cur"), e(this).addClass("cur"), e(".admission-ticket").hide(), e(".bar-code").show())
                        }), e(".studyNo").click(function () {
                            e(this).hasClass("cur") || (I = !0, H = !1, e(".barcode").removeClass("cur"), e(this).addClass("cur"), e(".bar-code").hide(), e(".admission-ticket").show(), t.createTable(11, parseInt(e("#slt-studyNo").find("option:selected").text())))
                        }), e(".two-code .radio-style").each(function (i) {
                            e(this).click(function () {
                                e(this).hasClass(".cur") || (e(".two-code .radio-style").removeClass("cur"), e(this).addClass("cur"), 0 == i ? (A = !0, e(".dtk-tips").show(), e(".dtk-tips").css({
                                    height: "55px",
                                    "line-height": "55px",
                                    "padding-bottom": "10px"
                                }), e(".dtk-name").css({"margin-top": "0px"})) : (A = !1, e(".dtk-tips").hide(), e(".dtk-tips").css({
                                    height: "0px",
                                    "line-height": "0px",
                                    "padding-bottom": "0px"
                                }), e(".dtk-name").css({"margin-top": "10px"})), t.nextDivCount("" + e(".dtk-subject-main div:first").attr("id")))
                            })
                        }), e(".is-give-points .radio-style").each(function (t) {
                            e(this).click(function () {
                                e(this).hasClass(".cur") || (e(".is-give-points .radio-style").removeClass("cur"), e(this).addClass("cur"), 0 == t ? (j = !0, e(".give-points").show(), e(".ke-container").addClass("w-100")) : (j = !1, e(".give-points").hide(), e(".ke-container").removeClass("w-100")))
                            })
                        }), e(".is-page-footer .radio-style").each(function (t) {
                            e(this).click(function () {
                                if (!e(this).hasClass(".cur")) {
                                    e(".is-page-footer .radio-style").removeClass("cur"), e(this).addClass("cur");
                                    for (var i = e(".mask").find(".mask-bg").length, n = 0; n < i; n++) 0 == t ? (q = !0, e(".mask .mask-bg").eq(n).find(".foot-num").html('第<i class="cur-page-num">' + (n + 1) + '</i>页 共<i class="total-page-num">' + i + "</i>页"), x = 1) : (q = !1, x = 0, e(".mask .mask-bg").eq(n).find(".foot-num").html('正<i class="cur-page-num">' + (n + 1) + "</i>"))
                                }
                            })
                        }), e("#slt-studyNo").change(function () {
                            var i = parseInt(e(this).find("option:selected").text());
                            N = i, e("#page-container .admission-ticket").html(""), t.createTable(11, i)
                        })
                    }, delOperation: function (t, i) {
                        function n(t) {
                            var i = "" + e("#" + t).next().attr("id");
                            if ("x" == t.charAt(t.length - 1) || "y" == t.charAt(t.length - 1)) {
                                if (a(t), e("#" + t).find(".dtk-editor").length > 0) {
                                    var o = e("#" + t).find(".dtk-editor").attr("id");
                                    window.KindEditor.remove("#" + o)
                                }
                                e("#" + t).remove(), n(i)
                            }
                        }

                        function a(t) {
                            var i = e("#" + t);
                            if (i.attr("data-topic-num-end")) {
                                var n = parseInt(i.attr("data-topic-num")), a = parseInt(i.attr("data-topic-num-end")) + 1;
                                for (n; n < a; n++) m.push(n)
                            } else if (i.attr("data-topic-num")) m.push(parseInt(i.attr("data-topic-num"))); else for (var p = 0; p < i.find(".choice-item").length; p++) {
                                var n = parseInt(i.find(".choice-item").eq(p).attr("data-topic-num"));
                                m.push(n)
                            }
                            for (s in m) for (o in k) k[o] == m[s] && k.splice(o, 1);
                            m = []
                        }

                        var o, s, p, d, r = this, c = 0, m = [], l = e("#" + t), b = 0;
                        "composition-box" == i ? (d = "" + l.find(".operation-bar").attr("data-box-del"), p = e("#" + d)) : (p = l, d = t), p.prev().length > 0 ? b = 1 : 0 == p.prev().length && (b = 1, c = 1);
                        var h = "" + p.next("." + i).attr("id"), u = "" + p.prev().attr("id");
                        e.when(a(d)).done(function () {
                            if (p.find(".dtk-editor").length > 0) {
                                var t = p.find(".dtk-editor").attr("id");
                                window.KindEditor.remove("#" + t)
                            }
                            "x" != d.charAt(d.length - 1) && "y" != d.charAt(d.length - 1) && p.next("." + i).length > 0 && n(h), p.remove(), b ? (c && (u = "" + e("#page-container .dtk-subject-main div:first").attr("id")), r.nextDivCount(u)) : r.addMask(), r.delOperationList()
                        })
                    }, operationBarDelOperation: function () {
                        var t = this;
                        e(".operation-bar .del").unbind(), e(".operation-bar .del").bind("click", function () {
                            function i() {
                                e("#" + a).prev().find(".line-edit").removeClass("no-visible");
                                var i = "" + e("#" + a).prev().attr("id"), o = e("#" + a).prev().length;
                                e.when(t.delOperation("" + a, n)).done(function () {
                                    r && (o > 0 ? t.subfieldRefresh(i) : t.subfieldRefresh())
                                })
                            }

                            var n = "" + e(this).parent(".operation-bar").attr("data-box"),
                                a = e(this).parents("." + n).attr("id");
                            e.when(t.findNextBoxX("" + a)).done(function () {
                                r ? (e("#notice-layer").show(), e("#notice-cancel").val("取消"), e("#notice-sure").unbind(), e("#notice-sure").bind("click", function () {
                                    e("#notice-layer").hide(), i()
                                })) : i()
                            })
                        })
                    }, delOperationList: function () {
                        var t = this;
                        e("#choice-del,#multiple-choice-del,#filling-del,#answer-del,#composition-del,#composition-en-del").hide(), e(".dtk-subject-main").children("div").length > 0 ? e(".topics-del").show() : e(".topics-del").hide();
                        var i, n, a = 0, o = 0, s = 0, p = 0, d = 0, r = 0, c = [], m = [], l = [], b = [], h = [], u = [];
                        e.when(function () {
                            e("#page-container .dtk-subject-main .choice-box").length > 0 && (e(".dtk-subject-main .choice-box").each(function () {
                                if ("radio-choice" == e(this).attr("data-choice")) {
                                    e("#choice-del").show(), a += parseInt(e(this).find(".choice-item").length);
                                    var t = "" + e(this).attr("id");
                                    "x" != t.charAt(t.length - 1) && "y" != t.charAt(t.length - 1) && c.push(t)
                                } else {
                                    e("#multiple-choice-del").show(), o += parseInt(e(this).find(".choice-item").length);
                                    var t = "" + e(this).attr("id");
                                    "x" != t.charAt(t.length - 1) && "y" != t.charAt(t.length - 1) && m.push(t)
                                }
                            }), e("#choice-del .self-topics-num").text(a), e("#multiple-choice-del .self-topics-num").text(o)), e("#page-container .dtk-subject-main .filling-box").length > 0 && (e("#filling-del").show(), e(".dtk-subject-main .filling-box").each(function () {
                                var t = "" + e(this).attr("id");
                                (e(this).attr("data-topic-num-end") || e(this).attr("data-topic-num")) && (s = s + parseInt(e(this).attr("data-topic-num-end")) - parseInt(e(this).attr("data-topic-num")) + 1), "x" != t.charAt(t.length - 1) && "y" != t.charAt(t.length - 1) && l.push(t)
                            }), e("#filling-del .self-topics-num").text(s)), e("#page-container .dtk-subject-main .answer-box").length > 0 && (e("#answer-del").show(), e(".dtk-subject-main .answer-box").each(function () {
                                var t = "" + e(this).attr("id");
                                e(this).attr("data-topic-num") && (p += 1), "y" != t.charAt(t.length - 1) && b.push(t)
                            }), e("#answer-del .self-topics-num").text(p)), e("#page-container .dtk-subject-main .composition-box").length > 0 && (e("#composition-del").show(), e(".dtk-subject-main .composition-box").each(function () {
                                var t = "" + e(this).attr("id");
                                "x" != t.charAt(t.length - 1) && "y" != t.charAt(t.length - 1) && (d += 1, h.push(t))
                            }), e("#composition-del .self-topics-num").text(d)), e("#page-container .dtk-subject-main .composition-en-box").length > 0 && (e("#composition-en-del").show(), e("#page-container .dtk-subject-main .composition-en-box").each(function () {
                                var t = "" + e(this).attr("id");
                                "x" != t.charAt(t.length - 1) && "y" != t.charAt(t.length - 1) && (r += 1, u.push(t))
                            }), e("#composition-en-del .self-topics-num").text(r))
                        }()).done(function () {
                            e(".topics-del .del-btn").unbind(), e(".topics-del .del-btn").bind("click", function () {
                                n = e(this).parents("tr").attr("id"), e("#notice-layer").show(), e("#notice-cancel").val("取消"), e("#notice-sure").unbind(), e("#notice-sure").bind("click", function () {
                                    switch (n) {
                                        case"choice-del":
                                            e(".dtk-subject-main .choice-box").each(function () {
                                                if ("" + e(this).attr("data-choice") == "radio-choice") return void(i = e(this).prev().attr("id"))
                                            });
                                            for (var a = 0; a < c.length; a++) t.delOperation("" + c[a], "choice-box");
                                            break;
                                        case"multiple-choice-del":
                                            e(".dtk-subject-main .choice-box").each(function () {
                                                if ("" + e(this).attr("data-choice") == "multiple-choice") return void(i = e(this).prev().attr("id"))
                                            });
                                            for (var o = 0; o < m.length; o++) t.delOperation("" + m[o], "choice-box");
                                            break;
                                        case"filling-del":
                                            i = e(".dtk-subject-main .filling-box:first").prev().attr("id");
                                            for (var s = 0; s < l.length; s++) t.delOperation("" + l[s], "filling-box");
                                            break;
                                        case"answer-del":
                                            i = e(".dtk-subject-main .answer-box:first").prev().attr("id");
                                            for (var p = 0; p < b.length; p++) t.delOperation("" + b[p], "answer-box");
                                            break;
                                        case"composition-del":
                                            i = e(".dtk-subject-main .composition-box:first").prev().attr("id");
                                            for (var d = 0; d < h.length; d++) t.delOperation("" + h[d], "composition-box");
                                            break;
                                        case"composition-en-del":
                                            i = e(".dtk-subject-main .composition-en-box:first").prev().attr("id");
                                            for (var r = 0; r < u.length; r++) t.delOperation("" + u[r], "composition-en-box")
                                    }
                                    i ? t.subfieldRefresh("" + i) : t.subfieldRefresh(), e("#notice-layer").hide()
                                })
                            })
                        })
                    }, subjectAddLayer: function () {
                        function t() {
                            e(".topic-name,.choice-start-end,.choice-number").show()
                        }

                        var i, n = this;
                        e(".btn-topics").each(function (a) {
                            e(this).click(function () {
                                switch (i = a, e("#submit1").hide(), e("#submit").show(), n.subjectLayer(), a) {
                                    case 0:
                                        e("#topic-name").val("单选题"), e("#choice-name").text("选项个数"), e("#choice-number").val(4), t();
                                        break;
                                    case 1:
                                        e("#topic-name").val("多选题"), e("#choice-name").text("选项个数"), e("#choice-number").val(4), t();
                                        break;
                                    case 2:
                                        e("#topic-name").val("填空题"), e("#choice-name").text("每行空数"), e("#choice-number").val(2), t();
                                        break;
                                    case 3:
                                        e("#topic-name").val("解答题"), e(".topic-name,.choice-start-end").show();
                                        break;
                                    case 4:
                                        e("#topic-name").val("语文作文题"), e("#choice-name").text("作文格数"), e("#choice-number").val(900), e(".topic-name,.choice-number").show();
                                        break;
                                    case 5:
                                        e("#choice-name").text("作文栏数"), e(".choice-number").show(), e("#choice-number").val(10)
                                }
                            })
                        }), e("#submit").unbind(), e("#submit").click(function () {
                            switch (i) {
                                case 0:
                                    n.choiceModule(!0, !1, "", 1, 12, 1, 150);
                                    break;
                                case 1:
                                    n.choiceModule(!1, !1, "", 1, 12, 1, 50);
                                    break;
                                case 2:
                                    n.editorAddModule("filling-box", 1, 5, 1, 50);
                                    break;
                                case 3:
                                    n.editorAddModule("answer-box", 1, 0, 1, 50);
                                    break;
                                case 4:
                                    n.compositionModule(!1, 1, 2e3, 0, 0);
                                    break;
                                case 5:
                                    n.editorAddModule("composition-en-box", 0, 20, 0, 0)
                            }
                            n.operationBarDelOperation(), n.delOperationList()
                        }), e("#subject-add-layer .close,#cancel").click(function () {
                            n.closeLayer()
                        })
                    }, subjectLayer: function () {
                        var t = this;
                        e(".topic-name,.choice-start-end,.choice-number").hide(), e("#subject-add-layer").show(), e("#hint").hide(), 0 == k.length ? e("#start-number").val(1) : "" == k[0] && 1 == k.length ? e("#start-number").val(1) : (k.sort(t.sortNumber), e("#start-number").val(parseInt(k[k.length - 1]) + 1))
                    }, createTable: function (t, i) {
                        e("#page-container .admission-ticket").html(" ");
                        var n = e('<table cellpadding="0" cellspacing="0" class="tab"></table>');
                        n.appendTo(e("#page-container .admission-ticket")), e('<caption class="bor"><strong>准考证</strong></caption>').appendTo(n);
                        for (var a = 0; a < t; a++) {
                            var o = e("<tr></tr>");
                            o.appendTo(n);
                            for (var s = 0; s < i; s++) if (0 == a) {
                                var p = e("<td>&nbsp;</td>");
                                p.appendTo(o)
                            } else {
                                var p = e("<td>[" + (a - 1) + "]</td>");
                                p.appendTo(o)
                            }
                        }
                    }, inputOperation: function (t, i) {
                        e(t).focus(function () {
                            e(this).attr("placeholder", "")
                        }), e(t).blur(function () {
                            e(this).attr("placeholder", i)
                        })
                    }, studentGridCount: function (t, i) {
                        function n(t) {
                            return a = e(0 == t ? '<span class="grid bor-le le"></span>' : '<span class="grid le"></span>')
                        }

                        var a, o = e(".dtk-basic-info .info-le .dl dd");
                        o.eq(0).find(".student-grid").html(""), o.eq(1).find(".student-grid").html(""), e(".dtk-type").find(".subfield").eq(2).hasClass("cur") ? e(".dtk-basic-info .info-ri").css({
                            top: "30px",
                            right: "0x"
                        }) : e(".dtk-basic-info .info-ri").css({
                            top: "0",
                            right: "0"
                        }), t > 8 ? (o.eq(0).find(".student-t").text("考 号："), o.eq(1).find(".student-t").text("姓 名：")) : (o.eq(0).find(".student-t").text("姓 名："), o.eq(1).find(".student-t").text("考 号："));
                        for (var s = 0; s < t; s++) n(s), o.eq(0).find(".student-grid").append(a);
                        for (var p = 0; p < i; p++) n(p), o.eq(1).find(".student-grid").append(a)
                    }, closeLayer: function () {
                        e("#start-number").val(""), e("#end-number").val(""), e("#subject-add-layer").hide(), e(".topic-name,.choice-start-end,.choice-number").hide()
                    }, choiceModule: function (t, i, n, a, o, s, d, r) {
                        function c(t, i, n) {
                            Y = e('<div class="choice-item" data-topic-num=' + t + "></div>"), Y.appendTo(u), e('<span class="No">' + t + "</span>").appendTo(Y), n && k.push(t);
                            for (var a, o = 0; o < i; o++) {
                                if (o < 0 || o > 25) return "F ";
                                a = o + 65, a = String.fromCharCode(a), e("<span>[" + a + "]</span>").appendTo(Y)
                            }
                        }

                        function m(i, n) {
                            e("#" + i).next("#" + i + "x").length > 0 && (e("#" + i + "x .operation-bar .add").bind("click", function () {
                                l.addItem(n, t)
                            }), m(i + "x", n))
                        }

                        var l = this;
                        if (l.contentVerify(a, o, s, d)) {
                            e("#subject-add-layer").hide();
                            var b = e("#page-container .dtk-content").outerHeight(!0);
                            if (i) {
                                var h, u = e("<li></li>"), f = e("#topic-name").val(),
                                    g = parseInt(e("#start-number").val()), v = parseInt(e("#end-number").val()),
                                    x = parseInt(e("#choice-number").val()), w = v - g + 1, C = Math.ceil(w / 5),
                                    y = e("#" + n).find(".ul"), T = y.find(".choice-item").length, M = y.find("li").length,
                                    H = T;
                                if (r) var h, u = e("<li></li>"), f = e("#" + n + " .name-title").text(), g = 0, v = 0,
                                    x = 0, w = 0, C = 0, y = e("#" + n).find(".ul"), T = y.find(".choice-item").length,
                                    M = y.find("li").length, H = T;
                                for (var I = [], N = [], q = [], A = 0; A < M; A++) for (var j = 0; j < y.find("li").eq(A).find(".choice-item").length; j++) {
                                    var B = parseInt(y.find("li").eq(A).find(".choice-item").eq(j).find(".No").text()),
                                        D = parseInt(y.find("li").eq(A).find(".choice-item").eq(j).find("span").length) - 1;
                                    I.push(B), N.push(B), q.push(D)
                                }
                                !function t(i) {
                                    if (e("#" + i).next("#" + i + "x").length > 0) {
                                        var n = e("#" + i + "x").find(".ul"), a = n.find(".choice-item").length;
                                        H += a;
                                        for (var o = n.find("li").length, s = 0; s < o; s++) for (var p = 0; p < n.find("li").eq(s).find(".choice-item").length; p++) {
                                            var d = parseInt(n.find("li").eq(s).find(".choice-item").eq(p).find(".No").text()),
                                                r = parseInt(n.find("li").eq(s).find(".choice-item").eq(p).find("span").length) - 1;
                                            I.push(d), N.push(d), q.push(r)
                                        }
                                        t(i + "x")
                                    }
                                }(n), h = w + H, t ? O += w : S += w;
                                for (var U, z, E = Math.ceil(h / 5), P = 0; P < w; P++) I.push(P + g), k.push(P + g);
                                y.html(" ");
                                var L = 0, F = "#" + n;
                                !function t(i) {
                                    e("#" + i).next("#" + i + "x").length > 0 && (L += 1, t(i + "x"))
                                }(n);
                                for (var R = 0; R < L; R++) F += "x", e(F).remove();
                                e("#" + n).find(".name-title").text(f), I.sort(l.sortNumber);
                                for (var G = 0; G < E; G++) if (u = e("<li></li>"), u.appendTo(y), h - 5 * G >= 5) for (var K = 5 * G; K < 5 * G + 5; K++) {
                                    for (U in N) {
                                        if (N[U] == I[K]) {
                                            z = q[U];
                                            break
                                        }
                                        z = x
                                    }
                                    c(I[K], z, !1)
                                } else for (var _ = 5 * G; _ < h; _++) {
                                    for (U in N) {
                                        if (I[_] == N[U]) {
                                            z = q[U];
                                            break
                                        }
                                        z = x
                                    }
                                    c(I[_], z, !1)
                                }
                                !function (i) {
                                    var n = e("#" + i).next().attr("id"),
                                        a = l.countUpHeight("#page-container .dtk-subject-main") + l.countUpHeight("#" + i) + 20;
                                    e("#" + i).attr("data-page-number", Math.ceil(a / 1116)), 1116 - a % 1116 - 40 > 230 ? (e("#" + i).css("margin-top", "0px"), e("#" + i).outerHeight(!0) > 1116 - a % 1116 - 40 && l.countPageHeight(i, 1116 - a % 1116 - 40, "", "", "", "", t)) : (e("#" + i).css("margin-top", 1116 - a % 1116 + 30 + "px"), e("#" + i).outerHeight() > 1076 ? l.countPageHeight(i, 1116 - a % 1116 + 1116 - 40, "", "", "", "", t) : l.addMask()), n && l.subfieldRefresh(i)
                                }(n), m(n, n)
                            } else {
                                var Q, g = parseInt(e("#start-number").val()), v = parseInt(e("#end-number").val()),
                                    x = parseInt(e("#choice-number").val()), f = e("#topic-name").val(),
                                    V = e(".mask .mask-bg").length;
                                t ? (O += v - g + 1, Q = "radio-choice") : (S += v - g + 1, Q = "multiple-choice"), p = g;
                                var X = e('<div class="choice-box" id="choice-box' + p + '" data-choice="' + Q + '" data-page-number="' + V + '"></div>'),
                                    $ = e('<div class="name-title" contenteditable="true">' + f + "</div>"),
                                    J = e('<div class="choice-content"></div>'), y = e('<ul class="ul noFloat"></ul>'),
                                    u = e("<li></li>"), Y = e('<div class="choice-item" data-topic-num=' + p + "></div>"),
                                    W = e('<div class="operation-bar" data-box="choice-box"><a class="max-hei" title="增加高度"></a><a class="min-hei" title="减小高度"></a><a class="bi" title="编辑"></a><a class="add" title="添加题目"></a><a class="a-split" title="拆分"></a><a class="a-optional" title="选做"></a><a class="del" title="删除"></a></div>'),
                                    w = v - g + 1, C = Math.ceil(w / 5);
                                X.appendTo(e("#page-container .dtk-subject-main")), $.appendTo(X), J.appendTo(X), W.appendTo(J), y.appendTo(J);
                                for (var Z = 0; Z < C; Z++) if (u = e("<li></li>"), u.appendTo(y), w - 5 * Z >= 5) for (var tt = 5 * Z; tt < 5 * Z + 5; tt++) c(tt + g, x, !0); else for (var et = 5 * Z; et < w; et++) c(et + g, x, !0);
                                e(".mask").outerHeight(!0) - b - 40 > 230 ? e(".mask").outerHeight(!0) - b - 40 < e("#choice-box" + p).outerHeight(!0) && l.countPageHeight("choice-box" + p, e(".mask").outerHeight(!0) - b - 40, "", "", "", "", t) : (V += 1, e("#choice-box" + p).attr("data-page-number", V), e("#choice-box" + p).css({"margin-top": e(".mask").outerHeight(!0) - b + 30 + "px"}), e("#choice-box" + p).outerHeight() > 1076 ? l.countPageHeight("choice-box" + p, e(".mask").outerHeight(!0) - b + 1116 - 40, "", "", "", "", t) : l.addMask());
                                var it = "#choice-box" + p + " .operation-bar .add", n = "choice-box" + p;
                                e(it).bind("click", function () {
                                    l.addItem(n, t)
                                }), l.operationBarDelOperation(), m("choice-box" + p, n)
                            }
                            l.operationBarIsDis("#choice-box" + p, 0, 0, 0, 1, 0, 0, 1), l.closeLayer()
                        }
                    }, addItem: function (t, i) {
                        function n(t) {
                            e("#" + t).next("#" + t + "x").length > 0 && (o = e("#" + t + "x").find(".choice-item").length + o, n(t + "x"))
                        }

                        var a = this;
                        a.subjectLayer(), e("#topic-name").val(e("#" + t).find(".name-title").text()), e(".topic-name,.choice-start-end,.choice-number").show(), e("#choice-number").val(4), e("#submit").hide(), e("#submit1").show(), e("#submit1").unbind();
                        var o = e("#" + t).find(".choice-item").length;
                        n("" + t), e("#submit1").bind("click", function () {
                            var n;
                            n = i ? 150 : 50, o + parseInt(e("#end-number").val()) - parseInt(e("#start-number").val()) + 1 > n ? (e("#hint").show(), e("#hint").text("每次添加该题型题目最大数量不能超过" + n + "个！")) : a.choiceModule(i, !0, t, 1, 12, 1, n), a.operationBarDelOperation(), a.delOperationList()
                        })
                    }, editorAddModule: function (t, i, n, a, o, s, d, r, c, m, l, b, h) {
                        function u(t, e) {
                            O.appendTo(B), v.editorModule(p, !0, t, e)
                        }

                        function f(i, n, a, o, s) {
                            38 * Math.ceil((o - a + 1) / s) + 58 - n > 0 ? f(i, n, a, o - s, s) : ((o - a + 1) % s != 0 && (o += s - (o - a + 1) % s), O = v.fillingModule(a, o, s, p), e("#" + i).attr("data-topic-num-end", o), v.creationFillingBox("" + t + p, n, !0, T, o + 1, M, M, s))
                        }

                        function g(t, e, i, n) {
                            38 * i + 58 - e > 0 ? g(t, e, i - 1, n) : (O = v.enCompositionModule(p, i, 0), v.creationEnCompositionBox(t, 1018, n - i, n - i, 1))
                        }

                        var v = this;
                        if (v.contentVerify(i, n, a, o)) {
                            var x = e(".mask").outerHeight(!0), w = e(".mask .mask-bg").length,
                                C = e(".dtk-content").outerHeight(!0), y = x - C, T = parseInt(e("#start-number").val()),
                                M = parseInt(e("#end-number").val()), H = parseInt(e("#choice-number").val()),
                                I = M - T + 1, N = e("#topic-name").val();
                            p = T, s && (w = r, T = c, M = m, H = l, I = M - T + 1, p = T, N = d, x = v.countUpHeight(".dtk-subject-main") + v.countUpHeight("#" + b) + e("#" + b).outerHeight(!0) + 20, b || (x = v.countUpHeight(".dtk-subject-main") + 20), y = 1116 - x % 1116, w = Math.ceil(x / 1116));
                            var q = e('<div class="' + t + '" id="' + t + p + '" data-topic-num="' + T + '" data-page-number="' + w + '"></div>'),
                                A = e('<div class="name-title" contenteditable="true">' + N + "</div>"),
                                j = e('<div class="edit-content no-toolbar" id="edit-content' + p + '"></div>'),
                                B = e('<div class="edit-area" id="edit-area' + p + '"></div>'),
                                O = e('<textarea name="content" class="dtk-editor" id="dtk-editor' + p + '"><div class="dtk-div"></div></textarea>'),
                                S = e('<div class="line-edit" id="line-edit' + p + '"></div>'),
                                z = e('<div class="operation-bar" data-box=' + t + '><a class="max-hei" title="增加高度"></a><a class="min-hei" title="减小高度"></a><a class="bi" title="编辑"></a><a class="add" title="添加题目"></a><a class="a-split" title="拆分"></a><a class="a-optional" title="选做"></a><a class="del" title="删除"></a></div>'),
                                P = e('<div class="merge"><div class="merge-tip" title="合并"></div></div>'),
                                L = e('<div class="give-points"><span>得分</span></div>');
                            e(".is-give-points .radio-style").eq(1).hasClass("cur") && (L = e('<div class="give-points" style="display: none"><span>得分</span></div>')), h ? q.insertBefore(e("#" + h)) : q.appendTo(e(".dtk-subject-main")), A.appendTo(q), j.appendTo(q), B.appendTo(j), z.appendTo(B), L.appendTo(B), S.appendTo(q);
                            var F = 38 * Math.ceil(I / H) + 58;
                            "filling-box" == t && (D += I, e("#" + t + p).attr("data-row-num", H), e.when(function () {
                                y - 40 < 230 ? (e("#" + t + p).css({"margin-top": y + 30 + "px"}), w += 1, e("#" + t + p).attr("data-page-number", w), F > 1076 ? (e("#" + t + p).find(".line-edit").addClass("no-visible"), f("" + t + p, 1076, T, M, H)) : (O = v.fillingModule(T, M, H, p), e("#" + t + p).attr("data-topic-num-end", M))) : (e("#" + t + p).css({"margin-top": "0px"}), y - 40 < F ? (e("#" + t + p).find(".line-edit").addClass("no-visible"), f("" + t + p, y - 40, T, M, H)) : (O = v.fillingModule(T, M, H, p), e("#" + t + p).attr("data-topic-num-end", M)))
                            }()).done(function () {
                                u("" + t + p)
                            })), "answer-box" == t && (U += I, O = e('<textarea name="content" class="dtk-editor" id="dtk-editor' + p + '"><div class="dtk-div"><span class="No No-w">' + T + "、</span>&ampnbsp;</div></textarea>"), k.push(T), P.appendTo(j), u("" + t + p, !0), y - 40 < 246 ? (e("#" + t + p).css({"margin-top": y + 30 + "px"}), e("#" + t + p).attr("data-page-number", w + 1)) : e("#" + t + p).css({"margin-top": "0px"}), v.answerModule("" + t + p, T, M, !0));
                            var R = 38 * H + 58;
                            "composition-en-box" == t && (e("#" + t + p).find(".name-title").text("英语作文题"), E += H, e("#" + t + p).attr("data-row-num", H), e.when(function () {
                                y - 40 < 230 ? (e("#" + t + p).css({"margin-top": y + 30 + "px"}), w += 1, e("#" + t + p).attr("data-page-number", w), R > 1076 ? (e("#" + t + p).find(".line-edit").addClass("no-visible"), g("" + t + p, 1018, H, H)) : O = v.enCompositionModule(p, H, 0)) : (e("#" + t + p).css({"margin-top": "0px"}), y - 40 < R ? (e("#" + t + p).find(".line-edit").addClass("no-visible"), g("" + t + p, y - 58 - 40, H, H)) : O = v.enCompositionModule(p, H, 0))
                            }()).done(function () {
                                u("" + t + p)
                            })), v.operationBarDelOperation(), v.nextDivCount("" + t + p), v.closeLayer(), v.operationBarIsDis("#" + t + p, 0, 0, 0, 0, 0, 0, 1)
                        }
                    }, editorModule: function (t, i, n, a, o, s, p, d) {
                        function r() {
                            e(b).removeClass("no-toolbar"), e(b).parents(".answer-box") && e(b).parents(".answer-box").prev(".answer-box").find(".merge").hide()
                        }

                        function c() {
                            e(b).hasClass("use-toolbar") || e(b).addClass("no-toolbar"), e(b).parents(".answer-box") && e(b).parents(".answer-box").prev(".answer-box").find(".merge").show()
                        }

                        var m = this;
                        if (o) var l = "#" + o, b = "#" + p, h = "#" + d, f = "#" + s; else var l = "#dtk-editor" + t,
                            b = "#edit-content" + t, h = "#edit-area" + t, f = "#line-edit" + t;
                        var g, v = h + " .ke-toolbar";
                        if (g = window.KindEditor.create(l, {
                                minHeight: "38px",
                                resizeType: 0,
                                items: ["formatblock", "fontsize", "bold", "underline", "strikethrough", "removeformat", "image", "table", "lineheight", "justifyleft", "justifycenter", "justifyright", "justifyfull", "indent", "outdent"],
                                fontSizeTable: ["9px", "10px", "12px", "14px", "16px", "18px", "24px", "32px"],
                                uploadJson: u + "/file/imageUpload",
                                allowImageUpload: !0,
                                filterMode: !1,
                                afterFocus: r,
                                afterBlur: c,
                                cssData: 'body,td{font-size: 12px;line-height: 1.5;font-family:Times,"Times New Roman",SimSun-ExtB,SimSun,NSimSun,serif;}.e-u{line-height:38px;}.No{display:inline-block;width:40px;text-align:right;}.No-w{width:auto;text-align:left;padding-left:20px;}.ke-content{overflow:hidden;}',
                                newlineTag: "br",
                                afterChange: function () {
                                    this.sync()
                                }
                            }), a) {
                            var x = g.edit.doc.body.scrollHeight + 150;
                            g.edit.setHeight(x)
                        } else {
                            var x = g.edit.doc.body.scrollHeight;
                            g.edit.setHeight(x)
                        }
                        e(".is-give-points .radio-style").eq(0).hasClass("cur") ? e(".ke-container").addClass("w-100") : e(".ke-container").removeClass("w-100"), window.KindEditor(b).bind("mouseenter", function () {
                            e(f).show()
                        }), window.KindEditor(b).bind("mouseleave", function () {
                            e(f).hide()
                        }), window.KindEditor(v).bind("mouseenter", function () {
                            e(b).addClass("use-toolbar")
                        }), window.KindEditor(v).bind("mouseleave", function () {
                            e(b).removeClass("use-toolbar")
                        }), i && m.lineHeightOperation(n, t, s, p, d)
                    }, fillingModule: function (t, i, n, a) {
                        var o = t, s = i, p = n, d = s - o + 1, r = "&ampnbsp;", c = "", m = "", l = "";
                        if (e(".dtk-type").find(".subfield").eq(2).hasClass("cur")) {
                            for (var b = 0; b < 7 - p; b++) r += r;
                            switch (p) {
                                case 1:
                                    h = "&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;", h += h, h += h;
                                    break;
                                case 2:
                                    h = "&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;", h += h;
                                    break;
                                case 3:
                                    h = "&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;", h += h;
                                    break;
                                case 4:
                                    h = "&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;", h += h;
                                    break;
                                case 5:
                                    h = "&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;"
                            }
                            var h;
                            r += h
                        } else {
                            for (var u = 0; u < 8 - p; u++) r += r;
                            var h = "&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;";
                            switch (p) {
                                case 1:
                                    var h = "&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;";
                                    r += h;
                                    break;
                                case 2:
                                case 3:
                                    var h = "&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;";
                                    r += h;
                                    break;
                                case 4:
                                    var h = "&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;";
                                    r += h;
                                    break;
                                case 5:
                                    var h = "&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;";
                                    r += h
                            }
                        }
                        for (var f = 0; f < d; f++) {
                            var g = f + o;
                            m = '<span class="No">' + g + "、</span>", k.push(g), c = '<u class="e-u">' + r + "</u>", l = (f + 1) % p == 0 ? l + m + c + "<br/>" : l + m + c
                        }
                        return e('<textarea name="content" class="dtk-editor" id="dtk-editor' + a + '"><div class="dtk-div">' + l + "&ampnbsp;</div></textarea>")
                    }, answerModule: function (t, i, n, a, o, s) {
                        for (var p, d, r, c = this, m = "", l = i, b = n, h = b - l, u = "", f = 0; f < h; f++) {
                            var g = void 0;
                            if (a) {
                                if (o) {
                                    g = t, d = e('<div class="answer-box" id="' + g + '" data-topic-num="' + (parseInt(e("#" + s).attr("data-topic-num")) + 1) + '" data-page-number=""></div>'), r = e('<div class="edit-content no-topbor no-toolbar" id="edit-content' + g + '"></div>'), p = e('<textarea name="content" class="dtk-editor" id="dtk-editor' + g + '"><div class="dtk-div">' + o + "&ampnbsp;</div></textarea>"), d.insertAfter(e("#" + s));
                                    var v = c.countUpHeight(".dtk-subject-main") + c.countUpHeight("#" + s) + e("#" + s).outerHeight(!0) + 20,
                                        x = 1116 - v % 1116 - 40, w = parseInt(e("#" + s).attr("data-page-number"));
                                    x < 246 && (w += 1), e("#" + g).attr("data-page-number", w)
                                } else {
                                    u = l + f + 1, m += "x", g = "" + t + m, k.push(u), d = e('<div class="answer-box" id="' + g + '" data-topic-num="' + u + '" data-page-number=""></div>'), r = e('<div class="edit-content no-topbor no-toolbar" id="edit-content' + g + '"></div>'), p = e('<textarea name="content" class="dtk-editor" id="dtk-editor' + g + '"><div class="dtk-div"><span class="No No-w">' + u + "、</span>&ampnbsp;</div></textarea>"), d.appendTo(e(".dtk-subject-main"));
                                    var C = e("#" + g).prev().attr("id"),
                                        v = c.countUpHeight(".dtk-subject-main") + c.countUpHeight("#" + C) + e("#" + C).outerHeight(!0) + 20,
                                        x = 1116 - v % 1116 - 40, w = parseInt(e("#" + C).attr("data-page-number"));
                                    x < 246 && (w += 1), e("#" + g).attr("data-page-number", w)
                                }
                                r.appendTo(d)
                            } else {
                                g = t + "y";
                                var y = parseInt(e("#" + t).attr("data-page-number")) + 1;
                                d = e('<div class="answer-box" id="' + g + '" data-page-number="' + y + '"></div>'), r = e('<div class="edit-content no-toolbar" id="edit-content' + g + '"></div>'), p = e('<textarea name="content" class="dtk-editor" id="dtk-editor' + g + '"></textarea>'), d.insertAfter(e("#" + t)), r.appendTo(d), e("#" + t).find(".line-edit").addClass("no-visible"), e("#" + t).find(".merge").addClass("no-visible"), e("#" + g).find(".edit-content").removeClass("no-topbor"), e("#" + g).next().find(".edit-content").addClass("no-topbor");
                                var T = c.countUpHeight(".dtk-subject-main") + c.countUpHeight("#" + g) + 20,
                                    M = 1116 - T % 1116;
                                e("#" + t + "y").css({"margin-top": M + 30 + "px"})
                            }
                            var H = e('<div class="edit-area" id="edit-area' + g + '"></div>'),
                                I = e('<div class="line-edit" id="line-edit' + g + '"></div>'),
                                N = e('<div class="operation-bar" data-box="answer-box"><a class="max-hei" title="增加高度"></a><a class="min-hei" title="减小高度"></a><a class="bi" title="编辑"></a><a class="add" title="添加题目"></a><a class="a-split" title="拆分"></a><a class="a-optional" title="选做"></a><a class="del" title="删除"></a></div>'),
                                q = e('<div class="merge"><div class="merge-tip" title="合并"></div></div>'),
                                A = e('<div class="give-points"><span>得分</span></div>');
                            e(".is-give-points .radio-style").eq(1).hasClass("cur") && (A = e('<div class="give-points" style="display: none"><span>得分</span></div>')), H.appendTo(r), p.appendTo(H), N.appendTo(H), a && A.appendTo(H), I.appendTo(d), q.appendTo(r), c.editorModule("" + g, !0, "" + g, !0), c.operationBarIsDis("#" + g, 0, 0, 0, 0, 0, 0, 1), c.operationBarDelOperation()
                        }
                        c.operationMergeBar()
                    }, compositionModule: function (t, i, n, a, o, s, r, c, m, l, b, h) {
                        var u = this, f = e(".dtk-content").outerHeight(!0), g = e(".mask").outerHeight(!0), v = g - f,
                            x = e(".mask .mask-bg").length, w = parseInt(e("#choice-number").val()),
                            C = e("#topic-name").val();
                        if (u.contentVerify(i, n, a, o)) {
                            var y;
                            y = e(".dtk-type").eq(2).find(".subfield").hasClass("cur") ? 16 : 22, 0 == k.length ? p = 0 : (k.sort(G.sortNumber), p = parseInt(k[k.length - 1])), r && (w = r, x = m, C = l, g = u.countUpHeight(".dtk-subject-main") + u.countUpHeight("#" + c) + e("#" + c).outerHeight(!0) + 20, c || (g = u.countUpHeight(".dtk-subject-main") + 20 + 38), v = 1116 - g % 1116, x = Math.ceil(g / 1116), p = b - 1);
                            var T = 40 * Math.ceil(w / y) + 55 + 46 + 20;
                            if (t) {
                                g = u.countUpHeight(".dtk-subject-main") + u.countUpHeight("#" + s) + e("#" + s).outerHeight(!0) + 20, v = 1116 - g % 1116;
                                var M = e("#" + s).find(".operation-bar").attr("data-box-del");
                                e("#" + M).attr("data-topic-total", parseInt(e("#choice-number").val()));
                                var H = e("#" + s).find(".composition-No").outerHeight(!0),
                                    I = [parseInt((v - 40) / 40) - 1] * y;
                                v - 40 < T && I < w ? (u.addCompositionGrid(y, d, I, 0, 1), u.countPageHeight(s, 1076, 0, w - I, y, I)) : u.addCompositionGrid(y, d, w, 0, 1), e("#" + s).find(".max-hei").unbind(), e("#" + s).find(".max-hei").bind("click", function () {
                                    u.maxMinHeightCount(s, 0, M, w)
                                }), e("#" + s).find(".min-hei").unbind(), e("#" + s).find(".min-hei").bind("click", function () {
                                    "x" == s.charAt(s.length - 1) && H <= 53 ? (e("#" + s).find(".operation-bar").removeClass("no-visible"), e("#" + s).find(".operation-bar").remove(), KindEditor.remove("#" + e("#" + s).find(".dtk-editor").attr("id")), e("#" + s).find(".composition-No").remove(), e("#" + s).prev().find(".operation-bar").removeClass("no-visible"), u.maxMinHeightCount("" + e("#" + s).prev().attr("id"), 1, M, w)) : u.maxMinHeightCount(s, 1, M, w)
                                }), e("#" + s).find(".bi").unbind(), e("#" + s).find(".bi").bind("click", function () {
                                    u.compositionBiOperation(e(this))
                                })
                            } else {
                                z += 1, p += 1, k.push(p);
                                var N = e('<div class="composition-box" id="composition-box' + p + '"  data-topic-num=' + p + ' data-topic-total="' + w + '" data-page-number="' + x + '"></div>'),
                                    q = e('<div class="name-title" contenteditable="true">' + C + "</div>"),
                                    A = e('<div class="composition-No"></div>'),
                                    j = e('<div class="composition-content" id="composition-content' + p + '"></div>'),
                                    B = e('<div class="composition-area noFloat" id="composition-area' + p + '"></div>'),
                                    O = e('<div class="operation-bar" data-box="composition-box" data-box-del="composition-box' + p + '"><a class="max-hei" title="增加高度"></a><a class="min-hei" title="减小高度"></a><a class="bi" title="编辑"></a><a class="add" title="添加题目"></a><a class="a-split" title="拆分"></a><a class="a-optional" title="选做"></a><a class="del" title="删除"></a></div>'),
                                    S = e('<div class="edit-content no-toolbar" id="edit-content' + p + '"></div>'),
                                    D = e('<div class="edit-area" id="edit-area' + p + '"></div>'),
                                    U = e('<textarea name="content" class="dtk-editor" id="dtk-editor' + p + '"><div class="dtk-div">' + p + "、&ampnbsp;</div></textarea>"),
                                    E = e('<div class="give-points"><span>得分</span></div>');
                                e(".is-give-points .radio-style").eq(1).hasClass("cur") && (E = e('<div class="give-points" style="display: none"><span>得分</span></div>')), h ? N.insertBefore(e("#" + h)) : N.appendTo(e(".dtk-subject-main")), q.appendTo(N), j.appendTo(N), A.appendTo(j), O.appendTo(j), B.appendTo(j), E.appendTo(j), S.appendTo(A), D.appendTo(S), U.appendTo(D), d = e("#composition-area" + p), u.editorModule("" + p, !1, "", !1);
                                var P = "#composition-box" + p;
                                e(P).find(".bi").unbind(), e(P).find(".bi").bind("click", function () {
                                    u.compositionBiOperation(e(this))
                                }), e(P).find(".max-hei").unbind(), e(P).find(".max-hei").bind("click", function () {
                                    var t = "" + e(this).parents(".composition-box").attr("id");
                                    u.maxMinHeightCount(t, 0, t, w)
                                }), e(P).find(".min-hei").unbind(), e(P).find(".min-hei").bind("click", function () {
                                    var t = "" + e(this).parents(".composition-box").attr("id");
                                    u.maxMinHeightCount(t, 1, t, w)
                                }), u.operationBarIsDis(P, 1, 1, 1, 0, 0, 0, 1), e(".dtk-type").eq(2).find(".subfield").hasClass("cur") ? e(".composition-box .composition-area").css({width: "479px"}) : e(".composition-box .composition-area").css({width: "659px"});
                                var I = [parseInt((v - 55 - 20 - 46) / 40) - 1] * y;
                                if (v - 40 > 230) e("#composition-box" + p).css({"margin-top": "0px"}), v - 40 < T ? (u.addCompositionGrid(y, d, I, 0, 1), u.countPageHeight("composition-box" + p, 1076, 0, w - I, y, I)) : u.addCompositionGrid(y, d, w, 0, 1); else if (e("#composition-box" + p).css({"margin-top": v + 30 + "px"}), x += 1, e("#composition-box" + p).attr("data-page-number", x), T > 1076) {
                                    var L = [Math.ceil(23.875) - 1] * y;
                                    u.addCompositionGrid(y, d, L, 0, 1), u.countPageHeight("composition-box" + p, 1076, 0, w - L, y, L)
                                } else u.addCompositionGrid(y, d, w, 0, 1), u.addMask()
                            }
                            u.operationBarDelOperation(), u.closeLayer()
                        }
                    }, compositionBiOperation: function (t) {
                        var i = this;
                        i.subjectLayer();
                        var n = t.parent(".operation-bar").attr("data-box-del");
                        e("#topic-name").val(e("#" + n).find(".name-title").text()), e("#choice-name").text("作文格数"), e(".topic-name,.choice-number").show(), e("#choice-number").val(900), e("#submit").hide(), e("#submit1").show(), e("#submit1").unbind(), e("#submit1").bind("click", function () {
                            if (i.contentVerify(1, 2e3, 0, 0)) {
                                if (d = t.parents(".composition-content").find(".composition-area"), d.html(" "), t.parents(".composition-box").next(".composition-box").length > 0) {
                                    var a = "" + t.parents(".composition-box").next().attr("id");
                                    !function t(i) {
                                        if ("x" == i.charAt(i.length - 1)) {
                                            var n = e("#" + i).next(".composition-box").attr("id");
                                            e("#" + i).remove(), t("" + n)
                                        }
                                    }(a)
                                }
                                e("#" + n).find(".name-title").text(e("#topic-name").val()), e.when(i.compositionModule(!0, 1, 2e3, 0, 0, "" + t.parents(".composition-box").attr("id"))).done(function () {
                                    i.addMask()
                                })
                            }
                        })
                    }, maxMinHeightCount: function (t, i, n, a) {
                        var o, s = this;
                        o = e(".dtk-type").eq(2).find(".subfield").hasClass("cur") ? 16 : 22;
                        var p = 40 * Math.ceil(a / o), r = e("#" + t).find(".composition-area").height(),
                            c = e("#" + t).find(".composition-No").height();
                        if (i) {
                            if (!(c > 38)) return;
                            r += 40, e("#" + t).find(".composition-No").height(c - 40), e("#" + t).find(".ke-edit").height(c - 40), e("#" + t).find(".ke-edit-iframe").height(c - 40)
                        } else {
                            if (!(r > 0)) return;
                            r -= 40, e("#" + t).find(".composition-No").height(c + 40), e("#" + t).find(".ke-edit").height(c + 40), e("#" + t).find(".ke-edit-iframe").height(c + 40)
                        }
                        if (d = e("#" + t).find(".composition-area"), d.html(" "), e("#" + t).next(".composition-box").length > 0) {
                            var m = "" + e("#" + t).next().attr("id");
                            !function t(i) {
                                if ("x" == i.charAt(i.length - 1)) {
                                    var n = e("#" + i).next(".composition-box").attr("id");
                                    e("#" + i).remove(), t("" + n), s.addMask()
                                }
                            }(m)
                        }
                        var l = s.countUpHeight(".dtk-subject-main") + s.countUpHeight("#" + t) + e("#" + t).outerHeight(!0) + 20,
                            b = 1116 - l % 1116, h = [parseInt((b - 40) / 40) - 1] * o;
                        if (b - 80 < p && r < p ? (s.addCompositionGrid(o, d, h, 0, 1), s.countPageHeight(t, 1021, 0, a - h, o, h)) : s.addCompositionGrid(o, d, a, 0, 1), !i && e("#" + t).find(".composition-area").height() <= 0) {
                            var u = t + "z";
                            e("#" + t).find(".operation-bar").addClass("no-visible");
                            var f = e('<div class="operation-bar" data-box="composition-box" data-box-del="' + n + '"><a class="max-hei" title="增加高度"></a><a class="min-hei" title="减小高度"></a><a class="bi" title="编辑"></a><a class="add" title="添加题目"></a><a class="a-split" title="拆分"></a><a class="a-optional" title="选做"></a><a class="del" title="删除"></a></div>'),
                                g = e('<div class="composition-No"></div>'),
                                v = e('<div class="edit-content no-toolbar" id="edit-content' + u + '"></div>'),
                                x = e('<div class="edit-area" id="edit-area' + u + '"></div>'),
                                k = e('<textarea name="content" class="dtk-editor" id="dtk-editor' + u + '"><div class="dtk-div">在此继续编辑</div></textarea>');
                            v.appendTo(g), x.appendTo(v), k.appendTo(x);
                            var w = "" + e("#" + t).next().attr("id");
                            f.prependTo(e("#" + w).find(".composition-content")), g.prependTo(e("#" + w).find(".composition-content")), s.editorModule("" + u, !1, "", !1), s.operationBarIsDis("#" + w, 1, 1, 1, 0, 0, 0, 1), s.operationBarDelOperation(), e("#" + w).find(".max-hei").bind("click", function () {
                                s.maxMinHeightCount(w, 0, n, a)
                            }), e("#" + w).find(".min-hei").bind("click", function () {
                                e("#" + w).find(".composition-No").height() <= 53 ? (e("#" + t).find(".operation-bar").removeClass("no-visible"), e("#" + w).find(".operation-bar").remove(), KindEditor.remove("#" + e("#" + w).find(".dtk-editor").attr("id")), e("#" + w).find(".composition-No").remove(), s.maxMinHeightCount(t, 1, n, a)) : s.maxMinHeightCount(w, 1, n, a)
                            }), e("#" + w).find(".bi").bind("click", function () {
                                s.compositionBiOperation(e(this))
                            })
                        }
                        s.operationBarDelOperation(), s.delOperationList()
                    }, addCompositionGrid: function (t, i, n, a, o) {
                        function s(t, i, n, a) {
                            d = t * n - t * n % 100, r = t - i == 0 ? 40 * i - 9 : 40 * (i + 1) - 9, c = 30 * [n - 1 - t * n % 100], m = e('<div class="grid-num" style="left:' + c + "px;top:" + r + 'px">' + d + "</div>"), m.appendTo(a)
                        }

                        for (var p, d, r, c, m, l = Math.ceil(n / t), b = 0; b < l; b++) {
                            for (var h = 0; h < t; h++) p = e(h == t - 1 ? '<div class="grid no-rightbor"></div>' : '<div class="grid"></div>'), p.appendTo(i);
                            var u = b + 1;
                            !function (t, e, i, n) {
                                var a;
                                switch (a = o ? t : t + Math.ceil(n / e)) {
                                    case Math.ceil(100 / e):
                                    case Math.ceil(200 / e):
                                    case Math.ceil(300 / e):
                                    case Math.ceil(400 / e):
                                    case Math.ceil(500 / e):
                                    case Math.ceil(600 / e):
                                    case Math.ceil(700 / e):
                                    case Math.ceil(800 / e):
                                    case Math.ceil(900 / e):
                                    case Math.ceil(1e3 / e):
                                    case Math.ceil(1100 / e):
                                    case Math.ceil(1200 / e):
                                    case Math.ceil(1300 / e):
                                    case Math.ceil(1400 / e):
                                    case Math.ceil(1500 / e):
                                    case Math.ceil(1600 / e):
                                    case Math.ceil(1700 / e):
                                    case Math.ceil(1800 / e):
                                    case Math.ceil(1900 / e):
                                    case Math.ceil(2e3 / e):
                                        s(a, t, e, i)
                                }
                            }(u, t, i, a + t)
                        }
                    }, enCompositionModule: function (t, i, n) {
                        var a, o, s, p = "", d = "";
                        a = e(".dtk-type").find(".subfield").eq(2).hasClass("cur") ? "&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;" : "&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;";
                        for (var r = 0; r < i; r++) {
                            if (n) s = t, p = '<span class="No"></span>'; else {
                                var c = t;
                                p = '<span class="No">' + c + "、</span>", k.push(c), s = c, n = 1
                            }
                            o = '<u class="e-u">' + a + "</u>", d = 0 == r ? p + o + "<br/>" : d + "&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;&ampnbsp;" + o + "<br/>"
                        }
                        return e('<textarea name="content" class="dtk-editor" id="dtk-editor' + s + '"><div class="dtk-div">' + d + "</div></textarea>")
                    }, lineHeightOperation: function (t, i, n, a, o) {
                        var s = this;
                        if (n) var p = e("#" + n), d = e("#" + t), r = e("#" + a),
                            c = e("#" + o); else var p = e("#line-edit" + i), d = e("#" + t), r = e("#edit-content" + i),
                            c = e("#edit-area" + i);
                        var m;
                        p.unbind(), e(document).unbind(), p.mousedown(function (i) {
                            var n, a = r.height(), o = i.clientY;
                            e(r).addClass("pointer-none"), e(document).mousemove(function (i) {
                                if (n = i.clientY, o - n > 0) {
                                    if (r.height() > 58) {
                                        var p = a - (o - n);
                                        if (r.height(p), c.height(p), d.find(".optional-desc").length > 0) {
                                            var l = d.find(".optional-desc").outerHeight(!0);
                                            c.find(".ke-edit").height(p - l), c.find(".ke-edit-iframe").height(p - l)
                                        } else c.find(".ke-edit").height(p), c.find(".ke-edit-iframe").height(p)
                                    } else g && (g = 0, d.find(".edit-content").addClass("pointer-none"));
                                    m = t
                                } else {
                                    var b = s.countUpHeight(".dtk-subject-main") + s.countUpHeight("#" + t) + 20;
                                    if (1116 - b % 1116 - 40 > 230) {
                                        if (d.outerHeight() < 1116 - b % 1116 - 40 - 55) {
                                            var p = a + Math.abs(o - n);
                                            if (r.height(p), c.height(p), d.find(".optional-desc").length > 0) {
                                                var l = d.find(".optional-desc").outerHeight(!0);
                                                c.find(".ke-edit").height(p - l), c.find(".ke-edit-iframe").height(p - l)
                                            } else c.find(".ke-edit").height(p), c.find(".ke-edit-iframe").height(p);
                                            m = t
                                        }
                                        if (d.outerHeight() > 1116 - b % 1116 - 40 - 55 - 1 && g) {
                                            g = 0, s.countPageHeight(t, 1021, !1);
                                            var h = d.next();
                                            h.find(".edit-content").addClass("pointer-none"), m = d.next().attr("id")
                                        }
                                    } else {
                                        if (d.outerHeight() < 1021) {
                                            var p = a + Math.abs(o - n);
                                            if (r.height(p), c.height(p), d.find(".optional-desc").length > 0) {
                                                var l = d.find(".optional-desc").outerHeight(!0);
                                                c.find(".ke-edit").height(p - l), c.find(".ke-edit-iframe").height(p - l)
                                            } else c.find(".ke-edit").height(p), c.find(".ke-edit-iframe").height(p);
                                            m = t
                                        }
                                        if (d.outerHeight() > 1020 && g) {
                                            g = 0, s.countPageHeight(t, 1021, !1);
                                            var h = d.next();
                                            h.find(".edit-content").addClass("pointer-none"), m = d.next().attr("id")
                                        }
                                    }
                                }
                                e(document).unbind("mouseup"), e(document).mouseup(function () {
                                    e(document).unbind(), e(r).removeClass("pointer-none"), d.next().find(".edit-content").removeClass("pointer-none"), g = 1, s.subfieldRefresh("" + m)
                                })
                            })
                        })
                    }, contentVerify: function (t, i, n, a) {
                        var o = e("#topic-name").val(), s = e("#start-number").val(), p = e("#end-number").val(),
                            d = e("#choice-number").val();
                        if (e("#hint").show(), setTimeout(function () {
                                e("#hint").hide()
                            }, 4e3), t && !o) return e("#hint").text(f.topicNameHint), !1;
                        if (n) {
                            if (!s) return e("#hint").text(f.startHint), !1;
                            if (!/^\+?[1-9][0-9]*$/.test(s)) return e("#hint").text(f.startNumIntHint), !1;
                            var r;
                            for (r in k) if (k[r] == s) return e("#hint").text("开始" + f.topicNumHint), !1
                        }
                        if (a) {
                            if (!p) return e("#hint").text(f.endHint), !1;
                            if (!/^\+?[1-9][0-9]*$/.test(p)) return e("#hint").text(f.endNumIntHint), !1;
                            if (parseInt(p) < parseInt(s)) return e("#hint").text("开始题号不能大于结束题号！"), !1;
                            if (p - s + 1 > a) return e("#hint").text("每次添加该题型题目最大数量不能超过" + a + "个！"), !1;
                            var r;
                            for (r in k) if (k[r] == p) return e("#hint").text("结束" + f.topicNumHint), !1
                        }
                        if (i) {
                            if (!d) return e("#hint").text(f.choiceNumberHint), !1;
                            if (!/^\+?[1-9][0-9]*$/.test(d)) return e("#hint").text(f.choiceNumIntHint), !1;
                            if (d > i) return e("#hint").text(e("#choice-name").text() + "最大不能超过" + i), !1
                        }
                        return !0
                    }, operationBarIsDis: function (t, i, n, a, o, s, p, d) {
                        e(".operation-bar a").hide(), e(t).unbind(), e(t).mouseover(function () {
                            e(this).find(".operation-bar").show(), i && e(this).find(".operation-bar a").eq(0).show(), n && e(this).find(".operation-bar a").eq(1).show(), a && e(this).find(".operation-bar a").eq(2).show(), o && e(this).find(".operation-bar a").eq(3).show(), s && e(this).find(".operation-bar a").eq(4).show(), p && e(this).find(".operation-bar a").eq(5).show(), d && e(this).find(".operation-bar a").eq(6).show()
                        }), e(t).mouseleave(function () {
                            e(this).find(".operation-bar").hide()
                        })
                    }, operationMergeBar: function () {
                        function t(t, i) {
                            function o(t) {
                                d = e(".answer-merge .dtk-div").eq(t).next(".dtk-y").length > 0 ? "" + e(".answer-merge .dtk-div").eq(t).html() + e(".answer-merge .dtk-div").eq(t).next(".dtk-y").html() : "" + e(".answer-merge .dtk-div").eq(t).html()
                            }

                            e(".answer-merge").html("");
                            var s = t.parents(".answer-box"), p = s.find(".dtk-editor").val();
                            e(".answer-merge").html(p);
                            var d, r = e(".answer-merge").find(".dtk-div").length, c = s.attr("id"), m = "" + s.attr("id"),
                                l = s.find(".dtk-editor").attr("id");
                            e.when(o(0)).done(function () {
                                n = e('<textarea name="content" class="dtk-editor" id="' + l + '"><div class="dtk-div"> ' + d + "</div></textarea>");
                                var t = e("#" + c).find(".line-edit").attr("id"),
                                    i = e("#" + c).find(".edit-content").attr("id"),
                                    o = e("#" + c).find(".edit-area").attr("id");
                                e("#" + t).removeClass("no-visible"), window.KindEditor.remove("#" + l), s.find(".dtk-editor").remove(), s.find(".optional-desc").remove(), s.find(".merge").show().removeClass("no-visible"), n.appendTo(e("#" + o)), a.editorModule("", !0, c, !0, l, t, i, o)
                            });
                            for (var b = 1; b < r; b++) c += "x", e.when(o(b)).done(function () {
                                a.answerModule(c, 0, 1, !0, d, m), m += "x"
                            });
                            s.find(".a-split ").hide(), s.find(".a-optional ").hide(), s.find(".a-split ").removeClass("dis-block"), s.find(".a-optional ").removeClass("dis-block"), a.myMarTopCount("" + e("#" + i).next().attr("id"))
                        }

                        function i(t) {
                            e(".answer-merge").html("");
                            var i = t.parents(".answer-box"), n = i.find(".edit-content").attr("id"),
                                o = i.find(".dtk-editor").val();
                            e(".answer-merge").html(o);
                            var s = e(".answer-merge").find(".dtk-div").length, p = e("#optional-layer"),
                                d = parseInt(i.attr("data-topic-num")), r = s + d - 1;
                            p.find(".No-start").text(d), p.find(".No-end").text(r), p.find(".No-total").text(s), p.find(".No-select span").text("1"), e("#optional-layer").show(), e("#optional-layer").attr("data-box", "" + n), a.optionalSubmit(i.attr("id"))
                        }

                        var n, a = this;
                        e(".operation-bar .dis-block").show(), e(".operation-bar .dis-block.a-split").unbind(), e(".operation-bar .dis-block.a-split").bind("click", function () {
                            var i = e(this), n = e(this).parents(".answer-box");
                            e.when(t(i, "" + n.attr("id"))).done(function () {
                                a.subfieldRefresh("" + n.next().attr("id"))
                            })
                        }), e(".operation-bar .dis-block.a-optional").unbind(), e(".operation-bar .dis-block.a-optional").bind("click", function () {
                            i(e(this))
                        }), e(".merge").hide(), e(".merge").each(function () {
                            var o = e(this).parents(".answer-box").next(".answer-box");
                            o.length > 0 && e(this).show(), e(this).mouseenter(function () {
                                o.length > 0 && "y" != ("" + o.attr("id")).charAt(("" + o.attr("id")).length - 1) && e(this).find(".merge-tip").show()
                            }), e(this).mouseleave(function () {
                                e(this).find(".merge-tip").hide()
                            }), e(this).find(".merge-tip").unbind(), e(this).find(".merge-tip").click(function () {
                                function o(t) {
                                    var i = e("#" + t).prev(".answer-box").attr("id"),
                                        n = e("#" + t).prev(".answer-box").find(".dtk-editor").val(),
                                        a = e("#" + t).prev(".answer-box").find(".dtk-editor").attr("id");
                                    "y" == ("" + i).charAt(("" + i).length - 1) ? (e("#" + t).remove(), window.KindEditor.remove("#" + a), c = '<div class="dtk-y">' + n + "</div>" + c, o(i)) : (window.KindEditor.remove("#" + a), e("#" + t).remove(), c = n + c, d = a)
                                }

                                var s = e(this).parents(".answer-box"), p = s.attr("id"),
                                    d = s.find(".dtk-editor").attr("id"), r = s.next(".answer-box").attr("id"),
                                    c = s.find(".dtk-editor").val(), m = e("#" + r).find(".dtk-editor").val(), l = "";
                                e.when(function () {
                                    window.KindEditor.remove("#" + d), "y" == ("" + p).charAt(("" + p).length - 1) && (c = '<div class="dtk-y">' + c + "</div>", o(p))
                                }(), function (t) {
                                    var i = e("#" + t).next(".answer-box").attr("id"),
                                        n = e("#" + t).next(".answer-box").find(".dtk-editor").val();
                                    "y" == ("" + i).charAt(("" + i).length - 1) && (a.delOperation(t, "filling-box"), m = m + '<div class="dtk-y">' + n + "</div>", o(i))
                                }(r)).done(function () {
                                    a.delOperation(r, "answer-box"), l = c + m, e(".answer-merge").html(l), e(".answer-merge .dtk-div").append("&ampnbsp;"), l = e(".answer-merge").html(), n = e('<textarea name="content" class="dtk-editor" id="' + d + '">' + l + "</textarea>"), p = e("#" + d).parents(".answer-box").attr("id");
                                    var o = e("#" + p).find(".line-edit").attr("id"),
                                        s = e("#" + p).find(".edit-content").attr("id"),
                                        b = e("#" + p).find(".edit-area").attr("id");
                                    e("#" + o).removeClass("no-visible"), e("#" + d).remove(), n.appendTo(e("#" + b)), a.editorModule("", !0, p, !0, d, o, s, b), e("#" + s + ",#" + b).css("height", "auto"), e("#" + p).find(".a-split ").addClass("dis-block"), e("#" + p).find(".a-optional ").addClass("dis-block"), e("#" + p).find(".a-split ").unbind(), e("#" + p).find(".a-split ").bind("click", function () {
                                        var i = e(this);
                                        e.when(t(i, "" + p)).done(function () {
                                            a.subfieldRefresh(e("#" + p).next().attr("id"))
                                        })
                                    }), e("#" + p).find(".a-optional ").unbind(), e("#" + p).find(".a-optional ").click(function () {
                                        i(e(this))
                                    });
                                    var h = 1116 - [a.countUpHeight(".dtk-subject-main") + a.countUpHeight("#" + p) + 20] % 1116;
                                    h - 40 < e("#" + p).outerHeight(!0) && (e("#" + p).find(".edit-content").removeClass("no-topbor"), e("#" + p).css({"margin-top": h + 20 + "px"}));
                                    var u = e("#" + p).next(".answer-box").attr("id");
                                    u && "y" != ("" + u).charAt(("" + u).length - 1) ? e("#" + p).find(".merge").show() : e("#" + p).find(".merge").hide(), a.subfieldRefresh("" + p)
                                })
                            })
                        }), e("#cancel2,#optional-layer .close").click(function () {
                            e("#optional-layer").hide()
                        })
                    }, optionalSubmit: function (t) {
                        function i(t) {
                            var i = parseInt(e("#optional-layer").find(".No-select span").text()),
                                n = parseInt(e("#optional-layer").find(".No-total").text());
                            t ? i < n - 1 && (i += 1, e("#optional-layer").find(".No-select span").text(i)) : i > 1 && (i -= 1, e("#optional-layer").find(".No-select span").text(i))
                        }

                        var n = this;
                        e("#submit2").unbind(), e("#submit2").click(function () {
                            var i = e("#optional-layer").attr("data-box"),
                                a = parseInt(e("#optional-layer").find(".No-start").text()),
                                o = parseInt(e("#optional-layer").find(".No-end").text()),
                                s = parseInt(e("#optional-layer").find(".No-select span").text()),
                                p = parseInt(e("#optional-layer").find(".No-total").text()), d = o + 1, r = "", c = "";
                            for (e("#" + i).find(".optional-desc").length > 0 && e("#" + i).find(".optional-desc").remove(), a; a < d; a++) c = c + '<span class="No-num">' + a + "</span>", r = a == d - 1 ? r + '<span class="No-num">' + a + "</span>" : r + '<span class="No-num">' + a + "、</span>";
                            var m = e('<div class="optional-desc"></div>'), l = e('<div class="optional-title">选考题</div>'),
                                b = e('<div class="optional-text">请考生从给出的 ' + r + ',<strong class="zongtishuo">' + p + "</strong>题中任选<strong>" + s + "</strong>题作答，如果多做，则按所选做的前一题计分，做答时，请用2B铅笔将所选题目对应题号涂黑</div>"),
                                h = e('<div class="optional-No">我选做的题号是' + c + "</div>");
                            l.appendTo(m), b.appendTo(m), h.appendTo(m), m.prependTo(e("#" + i)), e("#optional-layer").hide();
                            var u = 1116 - [n.countUpHeight(".dtk-subject-main") + n.countUpHeight("#" + t) + 20] % 1116;
                            u - 40 < e("#" + t).outerHeight(!0) && (e("#" + t).find(".edit-content").removeClass("no-topbor"), e("#" + t).css({"margin-top": u + 20 + "px"}));
                            var f = e("#" + i).find(".ke-edit").height(),
                                g = e("#" + i).find(".optional-desc").outerHeight(!0);
                            e("#" + t).find(".ke-edit").height(f - g), e("#" + t).find(".ke-edit-iframe").height(f - g), n.subfieldRefresh("" + t)
                        }), e(".btn-top").unbind(), e(".btn-btm").unbind(), e(".btn-top").click(function () {
                            i(!0)
                        }), e(".btn-btm").click(function () {
                            i(!1)
                        })
                    }, sortNumber: function (t, e) {
                        return t - e
                    }, countUpHeight: function (t) {
                        R = 0;
                        for (var i = e(t).prevAll().length, n = 0, a = 0; a < i; a++) n += e(t).parent().children().eq(a).outerHeight(!0);
                        return R = 1, n
                    }, addMask: function () {
                        var t, i = this, n = e(".mask"), a = e(".dtk-content").outerHeight(!0),
                            o = e(".mask").outerHeight(!0),
                            s = parseInt(e(".mask .mask-bg:last").find(".cur-page-num").text()),
                            p = e(".mask .mask-bg").length;
                        a > o ? (s += 1, p += 1, t = e(e(".is-page-footer .radio-style").eq(1).hasClass("cur") ? '<div class="mask-bg"><span class="foot-num">正<i class="cur-page-num">' + s + "</i></span></div>" : '<div class="mask-bg"><span class="foot-num">第<i class="cur-page-num">' + s + '</i>页 共<i class="total-page-num">' + p + "</i>页</span></div>"), t.appendTo(n), e(".total-page-num").text(e(".mask .mask-bg").length), i.addMask()) : o - a > 1116 && (e(".mask .mask-bg:last").remove(), e(".is-page-footer .radio-style").eq(0).hasClass("cur") && e(".total-page-num").text(e(".mask .mask-bg").length), i.addMask())
                    }, countPageHeight: function (t, e, i, n, a, o, s) {
                        var p = this;
                        -1 != t.indexOf("choice-box") && p.creationChoiceBox(t, e, s), -1 != t.indexOf("filling-box") && p.creationFillingBox(t, e, i, "", "", "", "", ""), -1 != t.indexOf("answer-box") && (p.answerModule(t, 0, 1, i), p.addMask()), -1 != t.indexOf("composition-box") && p.creationCompositiongBox(t, e, n, a, o), -1 != t.indexOf("composition-en-box") && (p.creationEnCompositionBox(t, e, "", "", i), p.addMask())
                    }, creationChoiceBox: function (t, i, n) {
                        var a, o = this;
                        n ? (O += 1, a = "radio-choice") : (S += 1, a = "multiple-choice");
                        var s = parseInt(e("#" + t).attr("data-page-number")) + 1,
                            p = e('<div class="choice-box" id="' + t + 'x" data-choice="' + a + '" data-page-number="' + s + '"></div>'),
                            d = e('<div class="choice-content"></div>'), r = e('<ul class="ul noFloat"></ul>'),
                            c = e('<div class="operation-bar" data-box="choice-box"><a class="max-hei" title="增加高度"></a><a class="min-hei" title="减小高度"></a><a class="bi" title="编辑"></a><a class="add" title="添加题目"></a><a class="a-split" title="拆分"></a><a class="a-optional" title="选做"></a><a class="del" title="删除"></a></div>');
                        p.insertAfter(e("#" + t)), d.appendTo(p), c.appendTo(d), r.appendTo(d), o.choiceBoxCount(t, i, n)
                    }, choiceBoxCount: function (t, i, n) {
                        var a = this, o = e("#" + t + "x").find(".ul");
                        e("#" + t + " .ul").find("li:last").prependTo(o), e("#" + t).outerHeight(!0) - i > 0 ? a.choiceBoxCount(t, i, n) : (a.nextDivCount("" + t), e("#" + t + "x").outerHeight(!0) > 1076 && a.countPageHeight(t + "x", 1076, "", "", "", "", n))
                    }, creationFillingBox: function (t, i, n, a, o, s, p, d) {
                        function r(t, i, n, a, p) {
                            38 * Math.ceil((a - n + 1) / p) + 10 - i > 0 ? r(t, i, n, a - p, p) : ((a - n + 1) % p != 0 && (a += p - (a - n + 1) % p), u = c.fillingModule(n, a, p, t), e("#" + t).attr("data-topic-num-end", a), c.creationFillingBox(t, i, !0, o, a + 1, s, s, p))
                        }

                        var c = this, m = parseInt(e("#" + t).attr("data-page-number")) + 1,
                            l = e('<div class="filling-box" id="' + t + 'x" data-topic-num="' + o + '" data-page-number="' + m + '" data-row-num="' + d + '"></div>'),
                            b = e('<div class="edit-content no-toolbar " id="edit-content' + t + 'x"></div>'),
                            h = e('<div class="edit-area" id="edit-area' + t + 'x"></div>'),
                            u = e('<textarea name="content" class="dtk-editor" id="dtk-editor' + t + 'x"><div class="dtk-div"></div></textarea>'),
                            f = e('<div class="line-edit" id="line-edit' + t + 'x"></div>'),
                            g = e('<div class="operation-bar" data-box="filling-box"><a class="max-hei" title="增加高度"></a><a class="min-hei" title="减小高度"></a><a class="bi" title="编辑"></a><a class="add" title="添加题目"></a><a class="a-split" title="拆分"></a><a class="a-optional" title="选做"></a><a class="del" title="删除"></a></div>');
                        l.insertAfter(e("#" + t)), b.appendTo(l), h.appendTo(b), g.appendTo(h), f.appendTo(l), e("#" + t).find(".line-edit").addClass("no-visible");
                        var v, x = 38 * Math.ceil((s - o + 1) / d) + 10;
                        n ? (x > 1018 ? r(t + "x", 1018, o, s, d) : (u = c.fillingModule(o, s, d, t + "x"), e("#" + t + "x").attr("data-topic-num-end", s)), v = !1) : v = !0, u.appendTo(h), c.editorModule(t + "x", !0, t + "x", v), c.operationBarIsDis("#" + t + "x", 0, 0, 0, 0, 0, 0, 1), c.operationBarDelOperation(), c.nextDivCount("" + t)
                    }, creationCompositiongBox: function (t, i, n, a, o) {
                        var s = this, p = parseInt(e("#" + t).attr("data-page-number")) + 1,
                            d = e('<div class="composition-box" id="' + t + 'x" data-page-number="' + p + '"></div>'),
                            r = e('<div class="composition-content" id="composition-content' + t + 'x"></div>'),
                            c = e('<div class="composition-area noFloat" id="composition-area' + t + 'x"></div>');
                        d.insertAfter(e("#" + t)), r.appendTo(d), c.appendTo(r), e(".dtk-type").eq(2).find(".subfield").hasClass("cur") ? e(".composition-box .composition-area").css({width: "479px"}) : e(".composition-box .composition-area").css({width: "659px"}), s.compositiongBoxCount(t, i, n, a, o)
                    }, compositiongBoxCount: function (t, i, n, a, o) {
                        var s = this, p = e("#" + t + "x").find(".composition-area");
                        if (40 * Math.ceil(n / a) > i) {
                            var d = [parseInt(i / 40) - 1] * a;
                            s.addCompositionGrid(a, p, d, o, 0), s.countPageHeight(t + "x", 1076, 0, n - d, a, o + d)
                        } else s.addCompositionGrid(a, p, n, o, 0);
                        s.nextDivCount("" + t)
                    }, creationEnCompositionBox: function (t, i, n, a, o) {
                        function s(t, e, i, n) {
                            38 * i + 10 - e > 0 ? s(t, e, i - 1, n) : (l = p.enCompositionModule(t, i, 1), p.creationEnCompositionBox(t, 1076, n - i, 1))
                        }

                        var p = this, d = parseInt(e("#" + t).attr("data-page-number")) + 1,
                            r = e('<div class="composition-en-box" id="' + t + 'x" data-page-number="' + d + '"></div>'),
                            c = e('<div class="edit-content no-toolbar " id="edit-content' + t + 'x"></div>'),
                            m = e('<div class="edit-area" id="edit-area' + t + 'x"></div>'),
                            l = e('<textarea name="content" class="dtk-editor" id="dtk-editor' + t + 'x"><div class="dtk-div"></div></textarea>'),
                            b = e('<div class="line-edit" id="line-edit' + t + 'x"></div>'),
                            h = e('<div class="operation-bar" data-box="composition-en-box"><a class="max-hei" title="增加高度"></a><a class="min-hei" title="减小高度"></a><a class="bi" title="编辑"></a><a class="add" title="添加题目"></a><a class="a-split" title="拆分"></a><a class="a-optional" title="选做"></a><a class="del" title="删除"></a></div>');
                        if (r.insertAfter(e("#" + t)), c.appendTo(r), m.appendTo(c), h.appendTo(m), b.appendTo(r), e("#" + t).find(".line-edit").addClass("no-visible"), o) 38 * n + 10 - i > 0 ? (e("#" + t + "x").find(".line-edit").addClass("no-visible"), s(t + "x", i, n, a)) : l = p.enCompositionModule(t + "x", n, 1), l.appendTo(m), p.editorModule(t + "x", !0, t + "x", !1); else {
                            l.appendTo(m), p.editorModule(t + "x", !0, t + "x", 1);
                            var u = p.countUpHeight(".dtk-subject-main") + p.countUpHeight("#" + t + "x") + 20,
                                f = 1116 - u % 1116;
                            e("#" + t + "x").css({"margin-top": f + 30 + "px"})
                        }
                        p.operationBarDelOperation(), p.operationBarIsDis("#" + t + "x", 0, 0, 0, 0, 0, 0, 1)
                    }, nextDivCount: function (t) {
                        var i = this,
                            n = i.countUpHeight(".dtk-subject-main") + i.countUpHeight("#" + t) + e("#" + t).outerHeight(!0) + 20,
                            a = "" + e("#" + t).next("div").attr("id");
                        F && (F = 0, 1116 - n % 1116 - 40 > 230 ? e("#" + t).next().outerHeight() > 1116 - n % 1116 - 40 ? (e("#" + t).next().css({"margin-top": 1116 - n % 1116 + 30 + "px"}), e("#" + t).next().attr("data-page-number", parseInt(e("#" + t).attr("data-page-number")) + 1), -1 != a.indexOf("answer-box") && e("#" + a).find(".edit-content").removeClass("no-topbor")) : (e("#" + t).next().css({"margin-top": "0px"}), e("#" + t).next().attr("data-page-number", parseInt(e("#" + t).attr("data-page-number"))), -1 != a.indexOf("answer-box") && ("x" != a.charAt(a.length - 1) && "y" != a.charAt(a.length - 1) || e("#" + a).find(".edit-content").addClass("no-topbor"))) : (e("#" + t).next().css({"margin-top": 1116 - n % 1116 + 30 + "px"}), e("#" + t).next().attr("data-page-number", parseInt(e("#" + t).attr("data-page-number")) + 1), -1 != a.indexOf("answer-box") && e("#" + a).find(".edit-content").removeClass("no-topbor")), F = 1, e("#" + t).next("div").length > 0 ? i.nextDivCount(e("#" + t).next("div").attr("id")) : i.addMask())
                    }, myMarTopCount: function (t) {
                        var i = this, n = i.countUpHeight(".dtk-subject-main") + i.countUpHeight("#" + t) + 20,
                            a = 1116 - n % 1116, o = Math.ceil(n / 1116);
                        a - 40 > e("#" + t).height() ? (e("#" + t).attr("data-page-number", o), e("#" + t).css("margin-top", "0px"), e("#" + t).prev().hasClass("answer-box") && e("#" + t).find(".edit-content").addClass("no-topbor")) : (e("#" + t).attr("data-page-number", o + 1), e("#" + t).css("margin-top", a + 30 + "px"), e("#" + t).find(".edit-content").removeClass("no-topbor"));
                        var s = e("#" + t).next(".answer-box").attr("id");
                        s && "y" != ("" + s).charAt(("" + s).length - 1) ? e("#" + s).find(".merge").show() : e("#" + s).find(".merge").hide(), i.addMask()
                    }, findNextBoxX: function (t) {
                        var i = this;
                        m = e("#" + t).next().attr("id"), m ? "x" == ("" + m).charAt(("" + m).length - 1) || "y" == ("" + m).charAt(("" + m).length - 1) ? i.findNextBoxX("" + m) : r = 1 : (r = 0, m = 0)
                    }, needLogin: function (t) {
                        // var i = this;
                        // e("#loading-layer").show(), e("#loading-layer").html('<div class="notice-text"><p>您还未登入，请前去<a href="' + t + '">' + t + '</a>登入！</p><p style="margin-top: 10px;"><span class="miao">5</span>秒后将为您跳转！</p></div>'), u = t, i.timedCount()
                    }, timedCount: function () {
                        var i = this;
                        e(".notice-text .miao").text(c), c -= 1, 0 == c ? (clearTimeout(t), location.href = u) : t = setTimeout(function () {
                            i.timedCount()
                        }, 1e3)
                    }
                };
            window.editCardOperation = G, G.autoOperation(), setTimeout(function () {
                e("#loading-layer").hide()
            }, 1e3)
        }).call(i, n(0))
    }, 4: function (t, e, i) {
        "use strict";

        function n(t) {
            var e, i, n, a, o, s;
            for (n = t.length, i = 0, e = ""; i < n;) {
                if (a = 255 & t.charCodeAt(i++), i == n) {
                    e += p.charAt(a >> 2), e += p.charAt((3 & a) << 4), e += "==";
                    break
                }
                if (o = t.charCodeAt(i++), i == n) {
                    e += p.charAt(a >> 2), e += p.charAt((3 & a) << 4 | (240 & o) >> 4), e += p.charAt((15 & o) << 2), e += "=";
                    break
                }
                s = t.charCodeAt(i++), e += p.charAt(a >> 2), e += p.charAt((3 & a) << 4 | (240 & o) >> 4), e += p.charAt((15 & o) << 2 | (192 & s) >> 6), e += p.charAt(63 & s)
            }
            return e
        }

        function a(t) {
            var e, i, n, a, o, s, p;
            for (s = t.length, o = 0, p = ""; o < s;) {
                do {
                    e = d[255 & t.charCodeAt(o++)]
                } while (o < s && -1 == e);
                if (-1 == e) break;
                do {
                    i = d[255 & t.charCodeAt(o++)]
                } while (o < s && -1 == i);
                if (-1 == i) break;
                p += String.fromCharCode(e << 2 | (48 & i) >> 4);
                do {
                    if (61 == (n = 255 & t.charCodeAt(o++))) return p;
                    n = d[n]
                } while (o < s && -1 == n);
                if (-1 == n) break;
                p += String.fromCharCode((15 & i) << 4 | (60 & n) >> 2);
                do {
                    if (61 == (a = 255 & t.charCodeAt(o++))) return p;
                    a = d[a]
                } while (o < s && -1 == a);
                if (-1 == a) break;
                p += String.fromCharCode((3 & n) << 6 | a)
            }
            return p
        }

        function o(t) {
            var e, i, n, a;
            for (e = "", n = t.length, i = 0; i < n; i++) a = t.charCodeAt(i), a >= 1 && a <= 127 ? e += t.charAt(i) : a > 2047 ? (e += String.fromCharCode(224 | a >> 12 & 15), e += String.fromCharCode(128 | a >> 6 & 63), e += String.fromCharCode(128 | a >> 0 & 63)) : (e += String.fromCharCode(192 | a >> 6 & 31), e += String.fromCharCode(128 | a >> 0 & 63));
            return e
        }

        function s(t) {
            var e, i, n, a, o, s;
            for (e = "", n = t.length, i = 0; i < n;) switch ((a = t.charCodeAt(i++)) >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    e += t.charAt(i - 1);
                    break;
                case 12:
                case 13:
                    o = t.charCodeAt(i++), e += String.fromCharCode((31 & a) << 6 | 63 & o);
                    break;
                case 14:
                    o = t.charCodeAt(i++), s = t.charCodeAt(i++), e += String.fromCharCode((15 & a) << 12 | (63 & o) << 6 | (63 & s) << 0)
            }
            return e
        }

        Object.defineProperty(e, "__esModule", {value: !0});
        var p = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/",
            d = new Array(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1);
        e.base64encode = n, e.base64decode = a, e.utf16to8 = o, e.utf8to16 = s
    }, 6: function (t, e) {
    }
}, [14]);