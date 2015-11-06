<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
  <!--头部-->
  <div class="am-g">
    <div data-am-widget="titlebar" class="am-titlebar am-titlebar-button list_title">
      <div class="am-titlebar-left">
        <a href="javascript:history.go(-1)" class="am-icon-reply" title="返回"></a>
      </div>
      <h2 class="am-titlebar-title">
        用户评价
      </h2>
      <div class="am-titlebar-right">
        <a href="index.html" class="am-icon-home am-icon-sm" title="首页"></a>
      </div>
    </div>
  </div>
  <!--//头部-->
  <!--评价列表-->
  <div class="am-g">
    <div data-am-widget="tabs" class="am-tabs am-tabs-d2 list_type_choose_title">
      <div class="am-g user_suggest">
        <ul class="am-tabs-hd am-cf sm-block-grid-3">
          <li class="am-tabs-hd-active">好评</li>
          <li class="">中评</li>
          <li class="">差评</li>
        </ul>
      </div>
      <div class="am-tabs-bd">
        <div class="am-tabs-bd-content">
          <div class="am-tabs-bd-active am-padding-vertical-sm"><!--好评-->
            <article class="am-comment am-margin-vertical-sm am-padding-horizontal-sm">
              <img src="<%=basePath %>assets/images/bw-2014-06-19.jpg" alt="" class="am-comment-avatar" width="48" height="48"/>
              <div class="am-comment-main">
                <header class="am-comment-hd">
                  <div class="am-comment-meta">
                    <a href="#" class="am-comment-author">某人</a>
                    评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
                  </div>
                </header>
                <div class="am-comment-bd user_comment-bd">
                  <p>　　<span class="am-link-muted">心得：</span>外观好看，声音轻，希望用的久一点。</p>
                  <p><span class="am-link-muted">购买日期：</span><time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time></p>
                  <blockquote><span class="am-text-danger">虎居回复：</span>我打算在下个月和樱子结婚。</blockquote>
                </div>
              </div>
            </article>
            <article class="am-comment am-margin-vertical-sm am-padding-horizontal-sm">
              <img src="images/bw-2014-06-19.jpg" alt="" class="am-comment-avatar" width="48" height="48"/>
              <div class="am-comment-main">
                <header class="am-comment-hd">
                  <div class="am-comment-meta">
                    <a href="#" class="am-comment-author">某人</a>
                    评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
                  </div>
                </header>
                <div class="am-comment-bd user_comment-bd">
                  <p>　　<span class="am-link-muted">心得：</span>非常中肯的评价。</p>
                  <p><span class="am-link-muted">购买日期：</span><time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time></p>
                  <blockquote><span class="am-text-danger">虎居回复：</span>我打算在下个月和樱子结婚。</blockquote>
                </div>
              </div>
            </article>
            <article class="am-comment am-margin-vertical-sm am-padding-horizontal-sm">
              <img src="<%=basePath %>assets/images/bw-2014-06-19.jpg" alt="" class="am-comment-avatar" width="48" height="48"/>
              <div class="am-comment-main">
                <header class="am-comment-hd">
                  <div class="am-comment-meta">
                    <a href="#" class="am-comment-author">某人</a>
                    评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
                  </div>
                </header>
                <div class="am-comment-bd user_comment-bd">
                  <p>　　<span class="am-link-muted">心得：</span>外观好看，声音轻，希望用的久一点。</p>
                  <p><span class="am-link-muted">购买日期：</span><time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time></p>
                  <blockquote><span class="am-text-danger">虎居回复：</span>我打算在下个月和樱子结婚。</blockquote>
                </div>
              </div>
            </article>
            <article class="am-comment am-margin-vertical-sm am-padding-horizontal-sm">
              <img src="<%=basePath %>assets/images/bw-2014-06-19.jpg" alt="" class="am-comment-avatar" width="48" height="48"/>
              <div class="am-comment-main">
                <header class="am-comment-hd">
                  <div class="am-comment-meta">
                    <a href="#" class="am-comment-author">某人</a>
                    评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
                  </div>
                </header>
                <div class="am-comment-bd user_comment-bd">
                  <p>　　<span class="am-link-muted">心得：</span>外观好看，声音轻，希望用的久一点。</p>
                  <p><span class="am-link-muted">购买日期：</span><time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time></p>
                </div>
              </div>
            </article>
            <article class="am-comment am-margin-vertical-sm am-padding-horizontal-sm">
              <img src="<%=basePath %>assets/images/bw-2014-06-19.jpg" alt="" class="am-comment-avatar" width="48" height="48"/>
              <div class="am-comment-main">
                <header class="am-comment-hd">
                  <div class="am-comment-meta">
                    <a href="#" class="am-comment-author">某人</a>
                    评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
                  </div>
                </header>
                <div class="am-comment-bd user_comment-bd">
                  <p>　　<span class="am-link-muted">心得：</span>外观好看，声音轻，希望用的久一点。</p>
                  <p><span class="am-link-muted">购买日期：</span><time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time></p>
                  <blockquote><span class="am-text-danger">虎居回复：</span>我打算在下个月和樱子结婚。</blockquote>
                </div>
              </div>
            </article>
            <article class="am-comment am-margin-vertical-sm am-padding-horizontal-sm">
              <img src="<%=basePath %>assets/images/bw-2014-06-19.jpg" alt="" class="am-comment-avatar" width="48" height="48"/>
              <div class="am-comment-main">
                <header class="am-comment-hd">
                  <div class="am-comment-meta">
                    <a href="#" class="am-comment-author">某人</a>
                    评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
                  </div>
                </header>
                <div class="am-comment-bd user_comment-bd">
                  <p>　　<span class="am-link-muted">心得：</span>外观好看，声音轻，希望用的久一点。</p>
                  <p><span class="am-link-muted">购买日期：</span><time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time></p>
                </div>
              </div>
            </article>
          </div><!--//好评-->
          <div><!--中评-->
            <article class="am-comment am-margin-vertical-sm am-padding-horizontal-sm">
              <img src="<%=basePath %>assets/images/bw-2014-06-19.jpg" alt="" class="am-comment-avatar" width="48" height="48"/>
              <div class="am-comment-main">
                <header class="am-comment-hd">
                  <div class="am-comment-meta">
                    <a href="#" class="am-comment-author">某人</a>
                    评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
                  </div>
                </header>
                <div class="am-comment-bd user_comment-bd">
                  <p>　　<span class="am-link-muted">心得：</span>外观好看，声音轻，希望用的久一点。</p>
                  <p><span class="am-link-muted">购买日期：</span><time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time></p>
                </div>
              </div>
            </article>
            <article class="am-comment am-margin-vertical-sm am-padding-horizontal-sm">
              <img src="<%=basePath %>assets/images/bw-2014-06-19.jpg" alt="" class="am-comment-avatar" width="48" height="48"/>
              <div class="am-comment-main">
                <header class="am-comment-hd">
                  <div class="am-comment-meta">
                    <a href="#" class="am-comment-author">某人</a>
                    评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
                  </div>
                </header>
                <div class="am-comment-bd user_comment-bd">
                  <p>　　<span class="am-link-muted">心得：</span>外观好看，声音轻，希望用的久一点。</p>
                  <p><span class="am-link-muted">购买日期：</span><time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time></p>
                  <blockquote><span class="am-text-danger">虎居回复：</span>我打算在下个月和樱子结婚。</blockquote>
                </div>
              </div>
            </article>
            <article class="am-comment am-margin-vertical-sm am-padding-horizontal-sm">
              <img src="<%=basePath %>assets/images/bw-2014-06-19.jpg" alt="" class="am-comment-avatar" width="48" height="48"/>
              <div class="am-comment-main">
                <header class="am-comment-hd">
                  <div class="am-comment-meta">
                    <a href="#" class="am-comment-author">某人</a>
                    评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
                  </div>
                </header>
                <div class="am-comment-bd user_comment-bd">
                  <p>　　<span class="am-link-muted">心得：</span>外观好看，声音轻，希望用的久一点。</p>
                  <p><span class="am-link-muted">购买日期：</span><time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time></p>
                </div>
              </div>
            </article>
          </div><!--中评-->
          <div><!--差评-->
            <article class="am-comment am-margin-vertical-sm am-padding-horizontal-sm">
              <img src="<%=basePath %>assets/images/bw-2014-06-19.jpg" alt="" class="am-comment-avatar" width="48" height="48"/>
              <div class="am-comment-main">
                <header class="am-comment-hd">
                  <div class="am-comment-meta">
                    <a href="#" class="am-comment-author">某人</a>
                    评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
                  </div>
                </header>
                <div class="am-comment-bd user_comment-bd">
                  <p>　　<span class="am-link-muted">心得：</span>差评；来啦啊啊啊</p>
                  <p><span class="am-link-muted">购买日期：</span><time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time></p>
                  <blockquote><span class="am-text-danger">虎居回复：</span>我打算在下个月和樱子结婚。</blockquote>
                </div>
              </div>
            </article>
            <article class="am-comment am-margin-vertical-sm am-padding-horizontal-sm">
              <img src="<%=basePath %>assets/images/bw-2014-06-19.jpg" alt="" class="am-comment-avatar" width="48" height="48"/>
              <div class="am-comment-main">
                <header class="am-comment-hd">
                  <div class="am-comment-meta">
                    <a href="#" class="am-comment-author">某人</a>
                    评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
                  </div>
                </header>
                <div class="am-comment-bd user_comment-bd">
                  <p>　　<span class="am-link-muted">心得：</span>外观好看，声音轻，希望用的久一点。</p>
                  <p><span class="am-link-muted">购买日期：</span><time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time></p>
                  <blockquote><span class="am-text-danger">虎居回复：</span>我打算在下个月和樱子结婚。</blockquote>
                </div>
              </div>
            </article>
            <article class="am-comment am-margin-vertical-sm am-padding-horizontal-sm">
              <img src="<%=basePath %>assets/images/bw-2014-06-19.jpg" alt="" class="am-comment-avatar" width="48" height="48"/>
              <div class="am-comment-main">
                <header class="am-comment-hd">
                  <div class="am-comment-meta">
                    <a href="#" class="am-comment-author">某人</a>
                    评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
                  </div>
                </header>
                <div class="am-comment-bd user_comment-bd">
                  <p>　　<span class="am-link-muted">心得：</span>外观好看，声音轻，希望用的久一点。</p>
                  <p><span class="am-link-muted">购买日期：</span><time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time></p>
                </div>
              </div>
            </article>
          </div><!--差评-->
        </div>
      </div>
    </div>
  </div>
  <!--//评价列表-->
