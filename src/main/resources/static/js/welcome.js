var user = sessionStorage.getItem('user')
			if (user == null){
				let name = prompt("Username")
			while(name === ''|| name === 'null'){
				name = prompt("Username")
			}
			fetch ('/users', {
					method: 'POST',
					body: name
			}).then(response => response.json())
			.then(user => {
				sessionStorage.setItem('user', JSON.stringify(user))
			})
			}else {
			user = JSON.parse(sessionStorage.getItem('user'))
		}