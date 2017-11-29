function load_more_post() {
	var post_num = $('.post').toArray().length
	console.log(post_num)
	
	$.post("/WebClass/loadpost.do", 
		{
		'search': 'json here?', 
        'isTimeline': true,
        'userToSearch': 'test@naver.com'
		},
		function(data) {
		var urlinfo = get_url_info(data, 
			function(data, urlinfo) {
			console.log('fuck: ' + urlinfo)
		    $('#posts').loadTemplate($('#post-template'),
			    {
			    profile_src: '/image/profiles/' + data.user.id + ".jpg",
			    nickname: data.user.nickname,
				title: data.post.title,
				url: data.post.url,
				surl: data.post.surl,
				url_title: urlinfo.title,
				url_thumbnail: urlinfo.thumbnail,
				url_text: urlinfo.description,
				user_text: data.post.userText,
				tags: data.post.tags
				}, 
				{ append: true })
			})
		})
}

function get_url_info(postdata, callback) {
	console.log('get: ' + postdata.post.url)
	$.get(postdata.post.url, function(data) {
		console.log(data)
		var title = $(data).filter('meta[name=title]').attr("content")
		if(title == undefined || title == null) title = $(data).filter('meta[property="og:title"]').attr("content")
		if(title == undefined || title == null) title = $(data).filter('title').text()
		console.log('title: ' + title)
			
		var thumbnail = $(data).filter('meta[property="og:image"]').attr("content")
		console.log('thumbnail: ' + thumbnail)
			
		var description = $(data).filter('meta[name=description]').attr("content")		
		if(description == null) description = $(data).filter('meta[property="og:description"]').attr("content")
		console.log('description: ' + description)

		var ret = {
				title: title,
				thumbnail: thumbnail,
			    description: description
		    }
		console.log(ret)
		callback(postdata, ret)
	})	
}
