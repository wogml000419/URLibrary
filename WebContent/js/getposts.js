function load_more_post(search, isTimeline, userToSearch, showError) {
	var post_num = $('.post').toArray().length
	for(var i = 0; i<4; i++)
	{
		console.log(post_num + i)
		$.post("/WebClass/loadpost.do", 
			{
			'search': search, 
	        'isTimeline': isTimeline,
	        'userToSearch': userToSearch,
	        'postNum': post_num + i,
	        'showerror': showError
			},
			function(data) {
			console.log('data: ' + data)
			if(data.msg == null || data.msg == undefined) {				
				get_url_info(data, 
					function(data, urlinfo) {
				    $('#posts').loadTemplate($('#post-template'),
					    {
				    	profile_href: 'timeline.do?userToSearch=' + data.user.id + '&showerror=false',
					    profile_src: '/image/profiles/' + data.user.id.replace('@', '') + ".jpg",
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
						{ append: true }
					)
				})
			}
			else {
				$('#error-title').text('오류')
				$('#error-msg').text(data.msg)
				$('#error-modal').modal()
			}
		})
	}
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
