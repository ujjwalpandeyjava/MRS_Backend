import { useState } from 'react';
import { flushSync } from 'react-dom';
import image1 from '../../images/Computer troubleshooting-amico.svg';
import image2 from '../notFound/404 Error with a cute animal-bro.svg';

export default function ViewTransitionEg() {
	const [isThumbnail, setIsThumbnail] = useState(true);

	const handleMove = () => {
		document.startViewTransition(() => {
			flushSync(() => {
				setIsThumbnail((prev) => !prev);
			});
		});
	};

	return (
		<div>
			<div className="top-bar">
				<div className="top-bar-content">
					<h1>Move Cat</h1>
					<button onClick={handleMove}>Move</button>
				</div>
				{isThumbnail ?
					<img style={{ viewTransitionName: `img-${isThumbnail}` }} src={image1} alt="cat" className="cat-img thumbnail" height={"300px"} width={"300px"} />
					: <div style={{ viewTransitionName: `img-${isThumbnail}` }} className="cat-details">
						<img src={image2} alt="cat" className="cat-img detailed-img" height={"100px"} width={"100px"} />
						<div className="cat-desc"><h2>Cat Details</h2></div>
					</div>
				}
			</div>
		</div>
	);
};