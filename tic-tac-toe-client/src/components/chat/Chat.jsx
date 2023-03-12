import React, {useState} from 'react';
import SockJsClient from 'react-stomp';

const SOCKET_URL = 'http://localhost:8080/ws-message';

const Chat = () => {
	const [message, setMessage] = useState('You server message here.');
	const [typedMessage, setTypedMessage] = useState('');
	const [clientRef, setClientRef] = useState();

	let onConnected = () => {
		console.log("Connected!!")
	}

	let onMessageReceived = (msg) => {
		// debugger;
		setMessage(msg.message);
	}

	let submitMessage = () => {
		clientRef.sendMessage('/app/sendMessage', JSON.stringify({
			message: typedMessage
		}));
		setTypedMessage('');
	};

	return (
			<div>
				<SockJsClient url={SOCKET_URL}
							  topics={['/topic/message']}
							  onConnect={onConnected}
							  onDisconnect={console.log("Disconnected!")}
							  onMessage={msg => onMessageReceived(msg)}
							  debug={false}
							  ref={(client) => {
								  setClientRef(client)
							  }}/>
				<div>{message}</div>
				<input value={typedMessage}
					   onChange={(event) => {
						   setTypedMessage(event.target.value);
					   }}/>
				<p>{typedMessage}</p>
				<button onClick={submitMessage}>Submit</button>
			</div>
	);
}

export default Chat;